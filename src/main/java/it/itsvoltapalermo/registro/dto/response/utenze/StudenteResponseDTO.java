package it.itsvoltapalermo.registro.dto.response.utenze;

import lombok.Data;

@Data
public class StudenteResponseDTO extends UtenteResponseDTO {

    private String corso;

    //TODO decidere come gestire le liste
}
