package it.itsvoltapalermo.registro.security.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.itsvoltapalermo.registro.dto.response.errors.MessageDTO;
import it.itsvoltapalermo.registro.mapper.MessageMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Handler personalizzato per la gestione degli accessi negati.
 * Implementa l'interfaccia AccessDeniedHandler di Spring Security per gestire le situazioni in cui un utente
 * autenticato non ha i privilegi necessari per accedere ad una risorsa.
 */
@Component
@AllArgsConstructor
public class AccessDeniedHandlerCustom implements AccessDeniedHandler {

    // Mapper per trasformare i messaggi di errore in oggetti MessageDTO
    private final MessageMapper messageMapper;
    // Mapper per la serializzazione in formato JSON
    private final ObjectMapper objectMapper;

    /**
     * Metodo chiamato in caso di accesso negato.
     * Verifica la presenza di un header "User" nella richiesta e imposta un messaggio d'errore personalizzato in base alla presenza o meno dell'header.
     *
     * @param request la richiesta HTTP in ingresso
     * @param response la risposta HTTP in uscita
     * @param accessDeniedException l'eccezione generata per l'accesso negato
     * @throws IOException in caso di errori durante la scrittura della risposta
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        // Recupera l'header "User" dalla richiesta
        String header = request.getHeader("Authorization");
        // Se l'header è presente, significa che l'utente è loggato, ma non ha i diritti necessari
        if (header != null) {
            setError(response, HttpStatus.UNAUTHORIZED, "l'utente " + header + " non ha i diritti");
        } else {
            // Se non c'è l'header, significa che non è stato effettuato il login
            setError(response, HttpStatus.FORBIDDEN, "Path non accessibile senza utente loggato");
        }
    }

    /**
     * Metodo helper per impostare il messaggio d'errore nella risposta HTTP.
     * Imposta lo status della risposta, il content type e scrive il messaggio d'errore in formato JSON.
     *
     * @param response la risposta HTTP da configurare
     * @param status lo status HTTP da impostare
     * @param message il messaggio di errore da inviare
     * @throws IOException in caso di errori durante la scrittura della risposta
     */
    private void setError(HttpServletResponse response, HttpStatus status, String message) throws IOException {
        // Imposta lo status HTTP della risposta
        response.setStatus(status.value());
        // Imposta il tipo di contenuto come JSON
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // Converte il messaggio in un oggetto MessageDTO utilizzando il mapper
        MessageDTO e = messageMapper.toMessageDto(messageMapper.toDoubleAttribute("ACCESS DENIED", message));
        // Scrive l'oggetto JSON nella risposta
        response.getWriter().write(objectMapper.writeValueAsString(e));
    }
}
