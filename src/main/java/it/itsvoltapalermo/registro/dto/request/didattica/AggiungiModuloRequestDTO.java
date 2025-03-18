package it.itsvoltapalermo.registro.dto.request.didattica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AggiungiModuloRequestDTO {

    @NotBlank(message = "Il modulo deve avere una denominazione")
    private String denominazione;

    @NotNull(message = "L'id del docente non può essere nullo")
    private long idCorso;

    @NotNull(message = "L'id del docente non può essere nullo")
    private long idDocente;
}
