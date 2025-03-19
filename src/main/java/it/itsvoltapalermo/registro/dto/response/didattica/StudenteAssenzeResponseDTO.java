package it.itsvoltapalermo.registro.dto.response.didattica;

import it.itsvoltapalermo.registro.dto.response.utenze.StudenteResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudenteAssenzeResponseDTO extends StudenteResponseDTO {

    private List<AssenzaResponseDTO> assenze;
    private double totaleOreAssenza;
}
