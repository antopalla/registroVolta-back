package it.itsvoltapalermo.registro.dto.response.didattica;

import lombok.Data;

@Data
public class ModuloResponseDTO {

    private long id;
    private String denominazione;

    private long idDocente;
    private long idCorso;

    //TODO decidere come gestire le liste
}
