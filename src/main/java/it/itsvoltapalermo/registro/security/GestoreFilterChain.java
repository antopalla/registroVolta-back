package it.itsvoltapalermo.registro.security;

import it.itsvoltapalermo.registro.model.Ruolo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class GestoreFilterChain {

    private final FilterDiAutenticazione filter;
    private final AuthenticationProvider provider;

    @Bean
    protected SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .headers(c -> c.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/docente/**").hasRole(Ruolo.DOCENTE.toString())
                        .requestMatchers("/tutor/**").hasAnyRole(Ruolo.TUTOR.toString(), Ruolo.DOCENTE.toString())
                        .requestMatchers("/admin/**").hasAnyRole(Ruolo.ADMIN.toString(), Ruolo.TUTOR.toString(), Ruolo.DOCENTE.toString())
                        .requestMatchers("/authorized/**").authenticated()
                        .anyRequest().permitAll()
                )
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(provider)
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
