package it.itsvoltapalermo.registro.dto.request.didattica;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModificaAssenzaRequestDTO {

    @NotNull(message = "Il campo id non può essere vuoto")
    private long id;

    private double durata;
}
