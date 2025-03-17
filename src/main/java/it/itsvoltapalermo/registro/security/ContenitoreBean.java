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
import org.springframework.web.server.ResponseStatusException;

@Configuration
@RequiredArgsConstructor
public class ContenitoreBean {

    private final UtenteRepository repo;

    @Bean
    protected UserDetailsService getDetailService() {
        return (u) -> repo.findByUsernameAndDisattivatoIsFalse(u).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
    }

    @Bean
    protected PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected AuthenticationManager getAuthenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    @Bean
    protected AuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
        dap.setUserDetailsService(getDetailService());
        dap.setPasswordEncoder(getPasswordEncoder());
        return dap;
    }
}
