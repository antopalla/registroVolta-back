package it.itsvoltapalermo.registro.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtException;
import it.itsvoltapalermo.registro.dto.response.errors.MessageDTO;
import it.itsvoltapalermo.registro.mapper.MessageMapper;
import it.itsvoltapalermo.registro.model.Utente;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

/**
 * Questo filtro di autenticazione viene eseguito una sola volta per ogni richiesta.
 * Esamina l'header "Authorization", estrae il token JWT e, se valido,
 * imposta l'utente autenticato nel contesto di sicurezza Spring.
 */
@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

    // Servizio per gestire il token e recuperare l'utente associato
    private final GestoreTokenService service;
    // Mapper per convertire i messaggi di errore in MessageDTO
    private final MessageMapper messageMapper;
    // Mapper per la serializzazione in formato JSON
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Estrae l'header "Authorization" dalla richiesta HTTP
        String header = request.getHeader("Authorization");

        // Verifica se l'header è presente e inizia con "Bearer "
        if (header != null && header.startsWith("Bearer ")) {
            // Se non è già presente un'autenticazione nel SecurityContext
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                Utente u = null;
                try {
                    // Tenta di ottenere l'utente a partire dal token
                    u = service.getUtenteByToken(header);
                } catch (ResponseStatusException | JwtException ex) {
                    String errorMsg = ex.getMessage();
                    if (errorMsg != null && errorMsg.contains("JWT expired")) {
                        // Se il token è scaduto, restituisci 401 con il messaggio "Login scaduto"
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        MessageDTO messageDTO = messageMapper.toMessageDto(messageMapper.toDoubleAttribute("authorization", "Login scaduto"));
                        response.getWriter().write(objectMapper.writeValueAsString(messageDTO));
                    } else {
                        // Altrimenti restituisci un errore generico (400 o un altro status)
                        response.setStatus(400);
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        MessageDTO messageDTO = messageMapper.toMessageDto(messageMapper.toDoubleAttribute("authorization", errorMsg));
                        response.getWriter().write(objectMapper.writeValueAsString(messageDTO));
                    }
                    return;
                }


                // Crea un token di autenticazione Spring basato sull'utente ottenuto e le sue authorities
                UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(u, null, u.getAuthorities());
                // Imposta i dettagli dell'autenticazione, utilizzando le informazioni della richiesta corrente
                upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // Imposta l'autenticazione nel SecurityContextHolder per rendere l'utente autenticato disponibile nel contesto
                SecurityContextHolder.getContext().setAuthentication(upat);
            }
        }
        // Procede con il filtro successivo nella catena
        filterChain.doFilter(request, response);
    }
}
