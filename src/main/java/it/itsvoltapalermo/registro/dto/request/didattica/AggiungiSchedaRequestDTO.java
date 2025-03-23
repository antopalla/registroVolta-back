package it.itsvoltapalermo.registro.dto.request.didattica;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AggiungiSchedaRequestDTO {

    @Min(value = 0, message = "Il campo livelloPreparazioneIngresso non può essere minore di 0")
    @Max(value = 5, message = "Il campo livelloPreparazioneIngresso non può essere maggiore di 5")
    private int livelloPreparazioneIngresso;

    @Min(value = 0, message = "Il campo socializzazione non può essere minore di 0")
    @Max(value = 5, message = "Il campo socializzazione non può essere maggiore di 5")
    private int socializzazione;

    @Min(value = 0, message = "Il campo comunicazione non può essere minore di 0")
    @Max(value = 5, message = "Il campo comunicazione non può essere maggiore di 5")
    private int comunicazione;

    @Min(value = 0, message = "Il campo impegno non può essere minore di 0")
    @Max(value = 5, message = "Il campo impegno non può essere maggiore di 5")
    private int impegno;

    @Min(value = 0, message = "Il campo motivazione non può essere minore di 0")
    @Max(value = 5, message = "Il campo motivazione non può essere maggiore di 5")
    private int motivazione;

    @Min(value = 0, message = "Il campo rispettoRegole non può essere minore di 0")
    @Max(value = 5, message = "Il campo rispettoRegole non può essere maggiore di 5")
    private int rispettoRegole;

    @Min(value = 0, message = "Il campo collaborazioneTutor non può essere minore di 0")
    @Max(value = 5, message = "Il campo collaborazioneTutor non può essere maggiore di 5")
    private int collaborazioneTutor;

    @Min(value = 0, message = "Il campo collaborazioneDocenti non può essere minore di 0")
    @Max(value = 5, message = "Il campo collaborazioneDocenti non può essere maggiore di 5")
    private int collaborazioneDocenti;

    @Min(value = 0, message = "Il campo collaborazioneColleghi non può essere minore di 0")
    @Max(value = 5, message = "Il campo collaborazioneColleghi non può essere maggiore di 5")
    private int collaborazioneColleghi;

    @Min(value = 0, message = "Il campo collaborazioneFamiliari non può essere minore di 0")
    @Max(value = 5, message = "Il campo collaborazioneFamiliari non può essere maggiore di 5")
    private int integrazioneGruppo;

    @Min(value = 0, message = "Il campo integrazioneGruppo non può essere minore di 0")
    @Max(value = 5, message = "Il campo integrazioneGruppo non può essere maggiore di 5")
    private int conoscenzaConcettiTecnici;

    @Min(value = 0, message = "Il campo conoscenzaConcettiTeorici non può essere minore di 0")
    @Max(value = 5, message = "Il campo conoscenzaConcettiTeorici non può essere maggiore di 5")
    private int conoscenzaConcettiTeorici;

    @Min(value = 0, message = "Il campo conoscenzaConcettiPratici non può essere minore di 0")
    @Max(value = 5, message = "Il campo conoscenzaConcettiPratici non può essere maggiore di 5")
    private int usoLinguaggioTerminologia;

    @Min(value = 0, message = "Il campo usoLinguaggioTerminologia non può essere minore di 0")
    @Max(value = 5, message = "Il campo usoLinguaggioTerminologia non può essere maggiore di 5")
    private int capacitaCollegamentoOrganizzazione;

    @Min(value = 0, message = "Il campo capacitaCollegamentoOrganizzazione non può essere minore di 0")
    @Max(value = 5, message = "Il campo capacitaCollegamentoOrganizzazione non può essere maggiore di 5")
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
