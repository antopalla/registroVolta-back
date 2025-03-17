package it.itsvoltapalermo.registro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
public class Lezione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate data;
    private Time oraInizio;
    private Time oraFine;

    private String descrizione;

    @OneToMany(mappedBy = "lezione", cascade = CascadeType.MERGE)
    private List<Assenza> assenze;

    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;

    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;

    private boolean disattivato;

}
