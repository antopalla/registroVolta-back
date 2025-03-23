package it.itsvoltapalermo.registro.dto.request.utenze;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AggiungiStudenteRequestDTO extends AggiungiUtenteRequestDTO {

    @NotNull(message = "Lo studente deve appartenere a un corso")
    private long idCorso;

}

