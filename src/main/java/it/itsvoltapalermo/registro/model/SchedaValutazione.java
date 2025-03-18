package it.itsvoltapalermo.registro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
public class SchedaValutazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String pathScheda;
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
    private String giudizioComplessivo;


    @ManyToOne
    @JoinColumn(name = "id_layout", nullable = false)
    private Layout layout;

    @ManyToOne
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;

    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;

    private boolean disattivato;

}
