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

    @NotBlank(message = "Il campo username non può essere vuoto")
    private String username;

    @NotNull(message = "Il campo password non può essere vuoto")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "La password deve contenere almeno 8 caratteri, di cui almeno una lettera maiuscola, una lettera minuscola e un numero")
    private String password;

    @Past(message = "Non puoi essere nato nel futuro")
    private LocalDate dataNascita;

    @NotNull(message = "Il campo codice fiscale non può essere vuoto")
    @Pattern(regexp = "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$", message = "Il codice fiscale non è valido")
    private String codiceFiscale;
}
