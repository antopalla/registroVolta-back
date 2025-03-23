package it.itsvoltapalermo.registro.dto.response.utenze;

import lombok.Data;

@Data
public class DocenteResponseDTO {

    private long id;
    private String nome;
    private String cognome;
    private String username;
    private String dataNascita;

    //TODO decidere come gestire le liste

}
