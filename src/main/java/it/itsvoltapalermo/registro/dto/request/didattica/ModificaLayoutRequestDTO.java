package it.itsvoltapalermo.registro.dto.request.didattica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModificaLayoutRequestDTO {

    @NotNull(message = "L'id non può essere nullo")
    private long id;
    @NotBlank(message = "Il nome no può essere vuoto")
    private String nome;
    @NotBlank(message = "La descrizione non può essere vuota")
    private String descrizione;

}
