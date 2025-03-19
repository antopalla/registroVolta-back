package it.itsvoltapalermo.registro.dto.response.utenze;

import lombok.Data;

@Data
public class StudenteResponseDTO {

    private long id;
    private String nome;
    private String cognome;
    private String corso;

    //TODO decidere come gestire le liste
}
