package it.itsvoltapalermo.registro.dto.response.didattica;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class LezioneResponseDTO {


    private long id;

    private LocalDate data;
    private Time oraInizio;
    private Time oraFine;

    private String descrizione;

    //TODO decidere come gestire le liste
}
