package it.itsvoltapalermo.registro.dto.request.didattica;

import lombok.Data;

@Data
public class AggiungiAssenzaRequestDTO {

    private double durata;

    private long idStudente;
    private long idLezione;
}
