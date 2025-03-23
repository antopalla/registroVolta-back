package it.itsvoltapalermo.registro.dto.response.utenze;

import lombok.Data;

@Data
public class UsernamePasswordResponseDTO {
    private String username;
    private String plainPassword;
}
