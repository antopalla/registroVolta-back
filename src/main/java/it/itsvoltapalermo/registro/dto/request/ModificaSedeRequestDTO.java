package it.itsvoltapalermo.registro.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ModificaSedeRequestDTO {

    @Min(value = 1, message = "L'id della sede non può essere minore di 1")
    private long id;

    @NotBlank(message = "La sede deve avere un nome")
    private String nome;

    @NotBlank(message = "La sede deve avere un indirizzo")
    private String indirizzo;

    @NotBlank(message = "La sede deve avere una citta")
    private String citta;

    @NotBlank(message = "La sede deve avere un CAP")
    private String cap;
}
