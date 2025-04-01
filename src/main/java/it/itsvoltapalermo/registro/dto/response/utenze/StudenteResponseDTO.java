package it.itsvoltapalermo.registro.dto.response.utenze;

import lombok.Data;

@Data
public class StudenteResponseDTO extends UtenteResponseDTO {

    private long idCorso;

    //TODO decidere come gestire le liste
}
