package it.itsvoltapalermo.registro.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModificaStudenteRequestDTO {

    @Min(value = 1, message = "L'id dell'utente non può essere minore di 1")
    private long id;

    @NotBlank(message = "Il cognome non può essere vuoto")
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto")
    private String cognome;

    @NotNull(message = "L'id del corso non può essere nullo")
    private long idCorso;
}
