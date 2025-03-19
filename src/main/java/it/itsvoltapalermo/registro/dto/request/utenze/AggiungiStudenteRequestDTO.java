package it.itsvoltapalermo.registro.dto.request.utenze;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AggiungiStudenteRequestDTO extends AggiungiUtenteRequestDTO {

    @NotBlank(message = "Lo studente deve apartenere a un corso")
    private long idCorso;

}

