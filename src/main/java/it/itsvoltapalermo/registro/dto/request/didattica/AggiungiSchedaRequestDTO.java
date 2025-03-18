package it.itsvoltapalermo.registro.dto.request.didattica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AggiungiSchedaRequestDTO {

    @NotBlank(message = "Il campo pathScheda non può essere nullo")
    private String pathScheda;

    @NotBlank(message = "Il campo pathFirma non può essere nullo")
    private String pathFirma;

    // Valutazioni da 0 (Insufficiente) a 5 (Ottimo)
    private int livelloPreparazioneIngresso;
    private int socializzazione;
    private int comunicazione;
    private int impegno;
    private int motivazione;
    private int rispettoRegole;
    private int collaborazioneTutor;
    private int collaborazioneDocenti;
    private int collaborazioneColleghi;
    private int integrazioneGruppo;
    private int conoscenzaConcettiTecnici;
    private int conoscenzaConcettiTeorici;
    private int usoLinguaggioTerminologia;
    private int capacitaCollegamentoOrganizzazione;
    private int livelloPreparazioneUscita;

    // Giudizio complessivo
    @NotBlank(message = "Il campo giudizioComplessivo non può essere nullo")
    private String giudizioComplessivo;

    @NotNull
    private long idDocente;

    @NotNull
    private long idStudente;

    @NotNull
    private long idLayout;

    @NotNull
    private long idModulo;

}
