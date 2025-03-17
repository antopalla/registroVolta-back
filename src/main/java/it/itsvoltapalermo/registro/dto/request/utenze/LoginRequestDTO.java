package it.itsvoltapalermo.registro.dto.request.utenze;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotNull(message = "Il campo username non può essere vuoto")
    private String username;

    @NotNull(message = "Il campo password non può essere vuoto")
    private String password;

}
