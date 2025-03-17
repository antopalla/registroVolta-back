package it.itsvoltapalermo.registro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String cognome;

    @OneToMany(mappedBy = "studente", cascade = CascadeType.MERGE)
    private List<Assenza> assenze;

    @OneToMany(mappedBy = "studente", cascade = CascadeType.MERGE)
    private List<SchedaValutazione> schedeValutazione;

    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;

    private boolean disattivato;
}
