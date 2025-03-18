package it.itsvoltapalermo.registro.dto.response.utenze;

import it.itsvoltapalermo.registro.model.Assenza;
import it.itsvoltapalermo.registro.model.Corso;
import lombok.Data;

import java.util.List;

@Data
public class StudenteResponseDTO {

    private long id;
    private String nome;
    private String cognome;
    private Corso corso;

    //TODO decidere come gestire le liste
}
