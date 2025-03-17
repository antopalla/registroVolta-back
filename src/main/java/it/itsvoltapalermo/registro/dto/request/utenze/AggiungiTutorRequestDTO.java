package it.itsvoltapalermo.registro.dto.request.utenze;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AggiungiTutorRequestDTO {

    @NotBlank(message = "Il campo nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "Il campo cognome non può essere vuoto")
    private String cognome;

    @NotBlank(message = "Il campo username non può essere vuoto")
    private String username;

    @NotNull(message = "Il campo password non può essere vuoto")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "La password deve contenere almeno 8 caratteri, di cui almeno una lettera maiuscola, una lettera minuscola e un numero")
    private String password;
}
