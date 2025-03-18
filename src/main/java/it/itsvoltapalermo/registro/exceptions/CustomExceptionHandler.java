package it.itsvoltapalermo.registro.exceptions;

import it.itsvoltapalermo.registro.dto.response.errors.MessageDTO;
import it.itsvoltapalermo.registro.dto.response.errors.DoubleAttributeDTO;
import it.itsvoltapalermo.registro.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handler globale per la gestione delle eccezioni in tutta l'applicazione.
 * Utilizza @RestControllerAdvice per intercettare e gestire centralmente le eccezioni sollevate durante l'elaborazione delle richieste.
 */
@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    // Mapper per convertire errori e messaggi in oggetti DTO
    private final MessageMapper mapper;

    /**
     * Gestisce le eccezioni relative a violazioni di integrità dei dati, come ad esempio quando si tenta di inserire un dato già presente.
     * Vengono gestite sia DataIntegrityViolationException che SQLIntegrityConstraintViolationException.
     *
     * @param e l'eccezione catturata
     * @return ResponseEntity con status HTTP CONFLICT (409) e il messaggio d'errore in formato JSON
     */
    @ExceptionHandler({DataIntegrityViolationException.class, SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<MessageDTO> conflictException(Exception e) {
        // Recupera il messaggio dell'eccezione
        String message = e.getMessage();
        // Determina la posizione in cui estrarre il nome dell'elemento in conflitto
        int start = message.indexOf("into") + 5;
        int end = message.indexOf("(");
        try {
            // Estrae e formatta il messaggio per indicare che l'elemento è già presente
            message = message.substring(start, end).trim() + " già presente";
        } catch (StringIndexOutOfBoundsException s) {
            // In caso di errore nell'estrazione, imposta un messaggio di default
            message = "utente già presente";
        }
        // Crea una lista di errori contenente un solo attributo
        List<DoubleAttributeDTO> errors = new ArrayList<>();
        errors.add(mapper.toDoubleAttribute("body", message));
        // Restituisce la risposta con status 409 (CONFLICT) e il messaggio d'errore
        return ResponseEntity.status(HttpStatus.CONFLICT).body(mapper.toMessageDto(errors));
    }

    /**
     * Gestisce le eccezioni di validazione degli argomenti dei metodi (ad es. errori nei dati in input).
     *
     * @param e l'eccezione MethodArgumentNotValidException catturata
     * @return ResponseEntity con status HTTP BAD_REQUEST (400) e i messaggi d'errore in formato JSON
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDTO> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        // Mappa i field error in una lista di DoubleAttributeDTO e li ordina
        List<DoubleAttributeDTO> errors = e.getBindingResult().getFieldErrors().stream()
                .map(mapper::toDoubleAttribute)
                .sorted()
                .toList();
        // Restituisce la risposta con status 400 (BAD_REQUEST) e i messaggi d'errore
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapper.toMessageDto(errors));
    }

    /**
     * Gestisce l'eccezione custom CustomResponseStatusException.
     *
     * @param e l'eccezione personalizzata catturata
     * @return ResponseEntity con status HTTP BAD_REQUEST (400) e il messaggio d'errore in formato JSON
     */
    @ExceptionHandler(CustomResponseStatusException.class)
    public ResponseEntity<MessageDTO> customResponseStatusException(CustomResponseStatusException e) {
        // Crea una lista di errori con il campo e il messaggio specificati nell'eccezione
        List<DoubleAttributeDTO> errors = new ArrayList<>();
        errors.add(mapper.toDoubleAttribute(e.getCampo(), e.getMessage()));
        // Restituisce la risposta con status 400 (BAD_REQUEST) e il messaggio d'errore
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapper.toMessageDto(errors));
    }

    /**
     * Gestisce l'eccezione HttpMessageNotReadableException, che si verifica quando il body della richiesta non è presente o non leggibile.
     *
     * @param e l'eccezione catturata
     * @return ResponseEntity con uno status HTTP personalizzato (I_AM_A_TEAPOT - 418) e il messaggio d'errore in formato JSON
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageDTO> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        List<DoubleAttributeDTO> errors = new ArrayList<>();
        // Se il messaggio indica che il body è mancante, imposta un messaggio più chiaro
        String message = e.getMessage() != null && e.getMessage().contains("Required request body is missing")
                ? "inserire il body per la request"
                : e.getMessage();
        errors.add(mapper.toDoubleAttribute("body", message));
        // Restituisce la risposta con status 418 (I_AM_A_TEAPOT) e il messaggio d'errore
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(mapper.toMessageDto(errors));
    }

    /**
     * Gestisce l'eccezione HttpRequestMethodNotSupportedException, che si verifica quando si utilizza un metodo HTTP non supportato.
     *
     * @param e l'eccezione catturata
     * @return ResponseEntity con status HTTP METHOD_NOT_ALLOWED (405) e il messaggio d'errore in formato JSON
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<MessageDTO> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        List<DoubleAttributeDTO> errors = new ArrayList<>();
        errors.add(mapper.toDoubleAttribute("protocol", e.getMessage()));
        // Restituisce la risposta con status 405 (METHOD_NOT_ALLOWED) e il messaggio d'errore
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(mapper.toMessageDto(errors));
    }

    /**
     * Gestisce l'eccezione MethodArgumentTypeMismatchException, che si verifica quando un argomento del metodo non corrisponde al tipo previsto.
     *
     * @param e l'eccezione catturata
     * @return ResponseEntity con status HTTP BAD_REQUEST (400) e il messaggio d'errore in formato JSON
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MessageDTO> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        List<DoubleAttributeDTO> errors = new ArrayList<>();
        errors.add(mapper.toDoubleAttribute("request", e.getMessage()));
        // Restituisce la risposta con status 400 (BAD_REQUEST) e il messaggio d'errore
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapper.toMessageDto(errors));
    }
}
