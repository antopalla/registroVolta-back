package it.itsvoltapalermo.registro.dto.request.utenze;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AggiungiStudenteRequestDTO {

    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "Il nome non può essere vuoto")
    private String cognome;

    @NotNull(message = "L'id del corso non può essere nullo")
    private long idCorso;
}

