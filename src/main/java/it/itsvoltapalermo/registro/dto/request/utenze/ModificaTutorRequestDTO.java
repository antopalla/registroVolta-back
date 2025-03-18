package it.itsvoltapalermo.registro.dto.request.utenze;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModificaTutorRequestDTO {

    @NotNull(message = "Il campo id non può essere vuoto")
    private long id;
    @NotBlank(message = "Il campo nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "Il campo cognome non può essere vuoto")
    private String cognome;

    @NotBlank(message = "Il campo username non può essere vuoto")
    private String username;
}
