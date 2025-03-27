package it.itsvoltapalermo.registro.security;

import it.itsvoltapalermo.registro.repository.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Classe di configurazione per la definizione dei bean relativi alla sicurezza.
 * Utilizza l'annotazione @Configuration per indicare che questa classe contiene definizioni di bean Spring.
 * L'annotazione @RequiredArgsConstructor di Lombok genera automaticamente un costruttore per gli attributi finali.
 */
@Configuration
@RequiredArgsConstructor
public class ContenitoreBean {

    // Repository per accedere ai dati dell'utente
    private final UtenteRepository repo;

    /**
     * Bean per il servizio che carica i dettagli dell'utente.
     * Effettua una ricerca dell'utente tramite username verificando che l'utente non sia disattivato.
     * Se l'utente non viene trovato, viene lanciata un'eccezione con status UNAUTHORIZED.
     */
    @Bean
    protected UserDetailsService getDetailService() {
        return (username) -> repo.findByUsernameAndDisattivatoIsFalse(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
    }

    /**
     * Bean per il password encoder.
     * Utilizza BCryptPasswordEncoder per garantire una crittografia sicura delle password.
     */
    @Bean
    protected PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean per l'AuthenticationManager.
     * Recupera il gestore di autenticazione dalla configurazione dell'autenticazione.
     *
     * @param auth la configurazione dell'autenticazione fornita da Spring
     * @return l'AuthenticationManager configurato
     * @throws Exception in caso di problemi nella configurazione
     */
    @Bean
    protected AuthenticationManager getAuthenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    /**
     * Bean per l'AuthenticationProvider.
     * Configura un DaoAuthenticationProvider che utilizza il UserDetailsService e il PasswordEncoder definiti.
     * Questo provider si occupa di verificare le credenziali dell'utente durante il processo di autenticazione.
     *
     * @return l'AuthenticationProvider configurato
     */
    @Bean
    protected AuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
        // Imposta il servizio per caricare i dettagli dell'utente
        dap.setUserDetailsService(getDetailService());
        // Imposta il password encoder per validare le password
        dap.setPasswordEncoder(getPasswordEncoder());
        return dap;
    }
}
