package it.itsvoltapalermo.registro.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * Eccezione personalizzata che estende RuntimeException e consente di specificare
 * uno status HTTP e un campo associato all'errore.
 * Le annotazioni Lombok @Data e @EqualsAndHashCode semplificano la generazione di getter, setter e metodi equals/hashCode.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomResponseStatusException extends RuntimeException {

    // Stato HTTP associato all'eccezione
    private HttpStatus status;
    // Campo relativo all'errore (ad esempio, il nome del campo in cui si è verificato il problema)
    private String campo;

    /**
     * Costruttore della CustomResponseStatusException.
     *
     * @param status lo stato HTTP da associare all'errore
     * @param campo il campo interessato dall'errore
     * @param message il messaggio d'errore
     */
    public CustomResponseStatusException(HttpStatus status, String campo, String message) {
        // Passa il messaggio d'errore al costruttore della superclasse (RuntimeException)
        super(message);
        this.status = status;
        this.campo = campo;
    }
}
