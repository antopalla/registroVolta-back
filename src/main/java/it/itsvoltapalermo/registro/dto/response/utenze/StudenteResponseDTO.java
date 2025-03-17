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

    private List<Assenza> assenze;

    private Corso corso;
}
