package it.itsvoltapalermo.registro.security.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.itsvoltapalermo.registro.dto.response.errors.MessageDTO;
import it.itsvoltapalermo.registro.mapper.MessageMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Handler personalizzato per la gestione delle richieste di autenticazione non riuscite.
 * Questo handler viene invocato quando non è presente un utente autenticato (o le credenziali non sono valide)
 * e gestisce la risposta HTTP di errore.
 */
@Component
@AllArgsConstructor
// Questo handler viene chiamato in caso di mancanza di autenticazione
public class SecurityResponseHandler implements AuthenticationEntryPoint {

    // Mapper per convertire messaggi di errore in oggetti MessageDTO
    private final MessageMapper mapper;
    // Mapper per la serializzazione degli oggetti in formato JSON
    private final ObjectMapper objectMapper;

    /**
     * Metodo chiamato quando l'autenticazione fallisce o non è presente.
     * Analizza la richiesta per verificare se è presente l'header "User" e imposta un messaggio di errore appropriato.
     *
     * @param request la richiesta HTTP in ingresso
     * @param response la risposta HTTP in uscita
     * @param authException l'eccezione generata durante il fallimento dell'autenticazione
     * @throws IOException in caso di errori nella scrittura della risposta
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // Recupera l'header "User" dalla richiesta
        String header = request.getHeader("Authorization");
        // Se l'header è presente, l'utente è riconosciuto ma non ha i diritti necessari
        if (header != null) {
            setError(response, HttpStatus.UNAUTHORIZED, "l'utente " + header + " non ha i diritti");
        } else {
            // Se l'header non è presente, significa che non è stato effettuato il login
            setError(response, HttpStatus.FORBIDDEN, "Path non accessibile senza utente loggato");
        }
    }

    /**
     * Metodo helper per impostare e inviare il messaggio di errore nella risposta HTTP.
     * Imposta lo status, il content type e serializza l'oggetto MessageDTO in JSON.
     *
     * @param response la risposta HTTP da configurare
     * @param status lo status HTTP da impostare
     * @param message il messaggio di errore da includere nel body della risposta
     * @throws IOException in caso di errori durante la scrittura della risposta
     */
    private void setError(HttpServletResponse response, HttpStatus status, String message) throws IOException {
        // Imposta lo status HTTP della risposta
        response.setStatus(status.value());
        // Imposta il tipo di contenuto a JSON
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // Converte il messaggio in un oggetto MessageDTO tramite il mapper
        MessageDTO e = mapper.toMessageDto(mapper.toDoubleAttribute("SECURITY", message));
        // Scrive l'oggetto JSON nella risposta HTTP
        response.getWriter().write(objectMapper.writeValueAsString(e));
    }
}
