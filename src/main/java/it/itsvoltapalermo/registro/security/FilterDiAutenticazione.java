package it.itsvoltapalermo.registro.security;

import it.itsvoltapalermo.registro.model.Utente;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FilterDiAutenticazione extends OncePerRequestFilter {

    private final GestoreTokenService service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                Utente d = null;
                try {
                    d = service.getUtente(header);
                } catch (ResponseStatusException e) {
                    response.sendError(e.getStatusCode().value(), e.getMessage());
                    return;
                }

                UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(d, null, d.getAuthorities());
                upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(upat);
            }
        }
        filterChain.doFilter(request, response);
    }
}
