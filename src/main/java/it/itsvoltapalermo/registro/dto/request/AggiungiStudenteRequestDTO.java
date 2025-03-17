package it.itsvoltapalermo.registro.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AggiungiStudenteRequestDTO {

    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "Il nome non può essere vuoto")
    private String cognome;

    @NotNull
    private long idCorso;
}

