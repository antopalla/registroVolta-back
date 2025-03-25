package it.itsvoltapalermo.registro.dto.response.didattica;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DiarioResponseDTO {

    private long id;
    private String aziendaOspitante;
    private String tutorAziendale;
    private LocalDate inizioTirocinio;
    private LocalDate fineTirocinio;
    private LocalDateTime dataCreazione = LocalDateTime.now();
}
