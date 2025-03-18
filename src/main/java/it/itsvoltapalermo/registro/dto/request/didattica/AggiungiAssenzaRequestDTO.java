package it.itsvoltapalermo.registro.dto.request.didattica;

import lombok.Data;

import java.sql.Time;

@Data
public class AggiungiAssenzaRequestDTO {

    private double durata;

    private long idStudente;
    private long idLezione;
}
