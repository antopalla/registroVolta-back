package it.itsvoltapalermo.registro.dto.request.governance;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModificaCorsoRequestDTO {

    @Min(value = 1, message = "L'id del corso non può essere minore di 1")
    private long id;

    @NotBlank(message = "La sede deve avere un nome")
    private String nome;

    @NotBlank(message = "La sede deve avere una descrizione")
    private String descrizione;

    @NotNull(message = "L'id del tutor non può essere nullo")
    private long idTutor;

    @NotNull(message = "L'id della sede non può essere nullo")
    private long idSede;
}
