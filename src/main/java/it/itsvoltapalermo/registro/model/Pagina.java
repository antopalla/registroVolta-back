package it.itsvoltapalermo.registro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.time.LocalDateTime;

@Data
@Entity
public class Pagina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //TODO risettare nullable a false
    @ManyToOne
    @JoinColumn(name = "id_diario", nullable = true)
    private DiarioDiBordo diarioDiBordo;


    private boolean disattivato;

    private LocalDate inizioSettimana; // ad esempio lunedì della settimana
    private LocalDate fineSettimana;   // domenica

    @Column(length = 1000)
    private String obiettiviSettimanali;

    @Column(length = 2000)
    private String attivitaSvolte;

    @Column(length = 2000)
    private String strumentiUtilizzati;

    @Column(length = 2000)
    private String difficoltaIncontrate;

    @Column(length = 2000)
    private String competenzeAcquisite;

    @Column(length = 2000)
    private String riferimentiDiscipline;

    @Column(length = 2000)
    private String riflessioniPersonali;

    private LocalDateTime dataCompilazione = LocalDateTime.now();

}
