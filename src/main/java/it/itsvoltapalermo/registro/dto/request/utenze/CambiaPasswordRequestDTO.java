package it.itsvoltapalermo.registro.dto.request.utenze;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CambiaPasswordRequestDTO {

    @NotNull(message = "Il campo vecchiaPassword non può essere vuoto")
    private String vecchiaPassword;

    @NotNull(message = "Il campo nuovaPassword non può essere vuoto")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "La password deve contenere almeno 8 caratteri, di cui almeno una lettera maiuscola, una lettera minuscola e un numero")
    private String nuovaPassword;

    @NotNull(message = "Il campo nuovaPasswordRipetuta non può essere vuoto")
    private String nuovaPasswordRipetuta;

}
