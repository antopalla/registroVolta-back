package it.itsvoltapalermo.registro.dto.request.governance;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AggiungiCorsoRequestDTO {

    @NotBlank(message = "Il corso deve avere un nome")
    private String nome;

    @NotBlank(message = "Il corso deve avere una descrizione")
    private String descrizione;

    @NotNull(message = "L'id del tutor non può essere nullo")
    private long idTutor;

    @NotNull(message = "L'id della sede non può essere nullo")
    private long idSede;
}
