package it.itsvoltapalermo.registro.dto.response.didattica;

import it.itsvoltapalermo.registro.dto.response.utenze.StudenteResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudenteAssenzeResponseDTO extends StudenteResponseDTO {

    //TODO rivedi qui per implementare gestione delle liste per mostrarle quando fai la get degli utenti
    private List<AssenzaResponseDTO> assenze;
    private double totaleOreAssenza;
}
