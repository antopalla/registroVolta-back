package it.itsvoltapalermo.registro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class DiarioDiBordo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "diarioDiBordo")
    private Studente studente;

    private String aziendaOspitante;
    private String tutorAziendale;
    private LocalDate inizioTirocinio;
    private LocalDate fineTirocinio;

    @OneToMany(mappedBy = "diarioDiBordo", cascade = CascadeType.MERGE)
    private List<Pagina> pagine;

    private LocalDateTime dataCreazione = LocalDateTime.now();

    private boolean disattivato;
}
