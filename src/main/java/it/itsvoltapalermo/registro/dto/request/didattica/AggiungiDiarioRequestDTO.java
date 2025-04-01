package it.itsvoltapalermo.registro.dto.request.didattica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class AggiungiDiarioRequestDTO {

    @NotBlank(message = "Il campo Azienda ospitante non può essere vuoto")
    private String aziendaOspitante;

    @NotBlank(message = "Il campo Tutor aziendale non può essere vuoto")
    private String tutorAziendale;

    @NotNull(message = "Il campo Inizio tirocinio non può essere nullo")
    private LocalDate inizioTirocinio;

    @NotNull(message = "Il campo Fine tirocinio non può essere nullo")
    private LocalDate fineTirocinio;

    private LocalDateTime dataCreazione = LocalDateTime.now();
}
