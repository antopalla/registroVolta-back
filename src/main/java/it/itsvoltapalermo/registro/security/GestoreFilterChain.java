package it.itsvoltapalermo.registro.security;

import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.security.handlers.SecurityResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * Configurazione della catena dei filtri di sicurezza per l'applicazione.
 * L'annotazione @EnableWebSecurity abilita la sicurezza web fornita da Spring Security.
 * @RequiredArgsConstructor genera automaticamente il costruttore per i campi finali.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class GestoreFilterChain {

    @Value("$(frontend.url}")
    private String frontendUrl;

    // Handler per la gestione delle risposte di errore in fase di autenticazione
    private final SecurityResponseHandler responseHandler;
    // Gestore per il controllo degli accessi negati
    private final AccessDeniedHandler accessDeniedHandler;
    // Filtro di autenticazione personalizzato da eseguire prima del filtro standard
    private final AuthenticationFilter filterBefore;
    // Filtro personalizzato per la gestione degli header da eseguire dopo l'autenticazione
    private final HeaderFilter filterAfter;
    // Provider per l'autenticazione, ad esempio un DaoAuthenticationProvider
    private final AuthenticationProvider provider;

    /**
     * Configura la SecurityFilterChain che definisce come vengono gestite le richieste HTTP.
     *
     * @param http l'oggetto HttpSecurity da configurare
     * @return la SecurityFilterChain configurata
     * @throws Exception in caso di errori di configurazione
     */
    @Bean
    protected SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
        String[] optionsPath = {"/login/**"};
        http
                // Disabilita la protezione CSRF
                .csrf(AbstractHttpConfigurer::disable)
                // Disabilita le restrizioni sugli header per i frame (utile ad esempio per visualizzare il contenuto in un iframe)
                .headers(c -> c.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                // Configurazione delle regole di autorizzazione per le richieste HTTP
                .authorizeHttpRequests(req -> req
                        .requestMatchers(HttpMethod.OPTIONS, optionsPath).permitAll()
                        .requestMatchers("/studente/**").hasAnyRole(Ruolo.ADMIN.toString(), Ruolo.TUTOR.toString(), Ruolo.DOCENTE.toString(), Ruolo.STUDENTE.toString())
                        // Solo gli utenti con ruolo DOCENTE possono accedere agli endpoint "/docente/**"
                        .requestMatchers("/docente/**").hasAnyRole(Ruolo.ADMIN.toString(), Ruolo.TUTOR.toString(), Ruolo.DOCENTE.toString())
                        // Gli utenti con ruolo TUTOR o DOCENTE possono accedere agli endpoint "/tutor/**"
                        .requestMatchers("/tutor/**").hasAnyRole(Ruolo.ADMIN.toString(), Ruolo.TUTOR.toString())
                        // Gli utenti con ruolo ADMIN, TUTOR o DOCENTE possono accedere agli endpoint "/admin/**"
                        .requestMatchers("/admin/**").hasRole(Ruolo.ADMIN.toString())
                        // Gli utenti autenticati possono accedere agli endpoint "/authorized/**"
                        .requestMatchers("/authorized/**").authenticated()
                        // Tutte le altre richieste sono permesse senza autenticazione
                        .anyRequest().permitAll()
                )
                // Gestione delle eccezioni di sicurezza
                .exceptionHandling(h -> h
                        // Imposta il gestore per l'entry point in caso di mancata autenticazione
                        .authenticationEntryPoint(responseHandler)
                        // Imposta il gestore per gli accessi negati
                        .accessDeniedHandler(accessDeniedHandler)
                )
                // Disabilita il CORS (Cross-Origin Resource Sharing) oppure ne delega la gestione altrove
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // Configura la gestione della sessione in modalità stateless (senza sessione)
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Imposta il provider di autenticazione da utilizzare
                .authenticationProvider(provider)
                // Aggiunge il filtro personalizzato per l'autenticazione prima del filtro standard di Spring
                .addFilterBefore(filterBefore, UsernamePasswordAuthenticationFilter.class)
                // Aggiunge il filtro personalizzato per la gestione degli header dopo il filtro di autenticazione
                .addFilterAfter(filterAfter, AuthenticationFilter.class);

        // Costruisce e restituisce la catena dei filtri configurata
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of(frontendUrl));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
