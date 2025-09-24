package it.itsvoltapalermo.registro.dto.response.didattica;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class LezioneResponseDTO {


    private long id;

    private String data;
    private String oraInizio;
    private String oraFine;

    private String descrizione;

    private long idCorso;
    private long idDocente;
    private long idModulo;
}
