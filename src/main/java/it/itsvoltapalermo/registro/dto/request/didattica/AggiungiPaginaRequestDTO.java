package it.itsvoltapalermo.registro.dto.request.didattica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AggiungiPaginaRequestDTO {

        //TODO rimettere  NotNull
        //@NotNull(message = "L'id del diario non può essere nullo")
        private long idDiario;

        @NotNull(message = "Il campo Inizio settimana non può essere nullo")
        private LocalDate inizioSettimana;

        @NotNull(message = "Il campo Fine settimana non può essere nullo")
        private LocalDate fineSettimana;

        @NotBlank(message = "Il campo Obiettivi settimanali non può essere vuoto")
        @Size(max = 1000, message = "Il campo Obiettivi settimanali non può superare i 1000 caratteri")
        private String obiettiviSettimanali;

        @NotEmpty(message = "Il campo Attività svolte non può essere vuoto")
        private String attivitaSvolte;

        @NotEmpty(message = "Il campo Strumenti utilizzati non può essere vuoto")
        private String strumentiUtilizzati;

        @NotEmpty(message = "Il campo Difficoltà incontrate non può essere vuoto")
        private String difficoltaIncontrate;

        @NotEmpty(message = "Il campo Competenze acquisite non può essere vuoto")
        private String competenzeAcquisite;

        @NotBlank(message = "Il campo Riferimenti alle discipline non può essere vuoto")
        @Size(max = 2000, message = "Il campo Riferimenti alle discipline non può superare i 2000 caratteri")
        private String riferimentiDiscipline;

        @NotBlank(message = "Il campo Riflessioni personali non può essere vuoto")
        @Size(max = 2000, message = "Il campo Riflessioni personali non può superare i 2000 caratteri")
        private String riflessioniPersonali;

        private LocalDateTime dataCompilazione = LocalDateTime.now();

    }

