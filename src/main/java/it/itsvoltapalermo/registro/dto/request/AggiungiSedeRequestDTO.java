package it.itsvoltapalermo.registro.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AggiungiSedeRequestDTO {

    @NotBlank(message = "La sede deve avere un nome")
    private String nome;

    @NotBlank(message = "La sede deve avere un indirizzo")
    private String indirizzo;

    @NotBlank(message = "La sede deve essere in una citta")
    private String citta;

    @NotNull(message = "la sede deve avere un CAP")
    private String cap;
}
