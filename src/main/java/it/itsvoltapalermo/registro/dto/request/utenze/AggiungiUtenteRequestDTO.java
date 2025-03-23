package it.itsvoltapalermo.registro.dto.request.utenze;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AggiungiUtenteRequestDTO {

    @NotBlank(message = "Il campo nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "Il campo nome non può essere vuoto")
    private String cognome;

    @Past(message = "Non puoi essere nato nel futuro")
    private LocalDate dataNascita;

    @NotNull(message = "Il campo codice fiscale non può essere vuoto")
    @Pattern(regexp = "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$", message = "Il codice fiscale non è valido")
    private String codiceFiscale;
}
