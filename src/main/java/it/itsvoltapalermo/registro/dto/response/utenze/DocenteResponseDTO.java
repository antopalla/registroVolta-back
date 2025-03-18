package it.itsvoltapalermo.registro.dto.response.utenze;

import it.itsvoltapalermo.registro.model.Ruolo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DocenteResponseDTO {

    private long id;
    private String nome;
    private String cognome;
    private String username;
    private LocalDate dataNascita;
    private Ruolo ruolo;

}
