package it.itsvoltapalermo.registro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String denominazione;

    private boolean disattivato;

    @OneToMany(mappedBy = "modulo", cascade = CascadeType.MERGE)
    private List<Lezione> lezioni;

    @OneToMany(mappedBy = "modulo", cascade = CascadeType.MERGE)
    private List<SchedaValutazione> schedeValutazione;

    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;

}
