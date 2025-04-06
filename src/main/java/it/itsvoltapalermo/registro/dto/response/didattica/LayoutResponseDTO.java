package it.itsvoltapalermo.registro.dto.response.didattica;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LayoutResponseDTO {

    private long id;
    private String nome;
    private String descrizione;
    private String path;
    private String dataCreazione;

}
