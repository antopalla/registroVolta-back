package it.itsvoltapalermo.registro.dto.request.utenze;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ModificaUtenteRequestDTO {

    @NotNull(message = "Il campo id non può essere vuoto")
    @Min(value = 1, message = "L'id dell'utente non può essere minore di 1")
    private long id;

    @NotBlank(message = "Il campo nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "Il campo cognome non può essere vuoto")
    private String cognome;

    @Past(message = "Non puoi essere nato nel futuro")
    private LocalDate dataNascita;

    @NotNull(message = "Il campo codice fiscale non può essere vuoto")
    @Pattern(regexp = "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$", message = "Il codice fiscale non è valido")
    private String codiceFiscale;
}
