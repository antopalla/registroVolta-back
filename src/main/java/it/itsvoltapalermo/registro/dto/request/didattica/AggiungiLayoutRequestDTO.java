package it.itsvoltapalermo.registro.dto.request.didattica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AggiungiLayoutRequestDTO {

    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;
    @NotBlank(message = "La descrizione non può essere vuota")
    private String descrizione;

    @NotNull
    private MultipartFile file;

}
