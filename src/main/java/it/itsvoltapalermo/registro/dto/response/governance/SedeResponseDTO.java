package it.itsvoltapalermo.registro.dto.response.governance;

import lombok.Data;

@Data
public class SedeResponseDTO {

    private long id;
    private String nome;
    private String indirizzo;
    private String citta;
    private String cap;

    //TODO decidere come gestire le liste

}
