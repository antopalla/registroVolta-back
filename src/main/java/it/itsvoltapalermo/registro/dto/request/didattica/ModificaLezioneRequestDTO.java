package it.itsvoltapalermo.registro.dto.request.didattica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class ModificaLezioneRequestDTO {

    @NotNull(message = "L'id non può essere nullo")
    private long id;

    private String data;
    private String oraInizio;
    private String oraFine;

    @NotBlank(message = "La descrizione non può essere vuota")
    private String descrizione;

    @NotNull(message = "L'id del modulo non può essere nullo")
    private long idModulo;
    @NotNull(message = "L'id del corso non può essere nullo")
    private long idCorso;
    @NotNull(message = "L'id del docente non può essere nullo")
    private long idDocente;

}
