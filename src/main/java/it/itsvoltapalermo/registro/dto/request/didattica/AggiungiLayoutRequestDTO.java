package it.itsvoltapalermo.registro.dto.request.didattica;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class AggiungiLayoutRequestDTO {

    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;
    @NotBlank(message = "La descrizione non può essere vuota")
    private String descrizione;

    @NotBlank(message = "Il path non può essere vuoto")
    private String path;

    private String dataCreazione;

}
