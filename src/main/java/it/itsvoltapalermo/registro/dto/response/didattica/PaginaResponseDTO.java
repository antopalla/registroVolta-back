package it.itsvoltapalermo.registro.dto.response.didattica;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PaginaResponseDTO {

        private long id;

        private String diario;

        private LocalDate inizioSettimana; // ad esempio lunedì della settimana
        private LocalDate fineSettimana;   // domenica
    
        private String obiettiviSettimanali;
        
        private String attivitaSvolte;

        private String strumentiUtilizzati;

        private String difficoltaIncontrate;
        
        private String competenzeAcquisite;

        private String riferimentiDiscipline;

        private String riflessioniPersonali;

        //TODO rivedi se va inserito questo campo
        private LocalDateTime dataCompilazione = LocalDateTime.now();
        
}
