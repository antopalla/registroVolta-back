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
@DiscriminatorValue("Studente")
public class Studente extends Utente{

    @OneToMany(mappedBy = "studente", cascade = CascadeType.MERGE)
    private List<Assenza> assenze;

    @OneToMany(mappedBy = "studente", cascade = CascadeType.MERGE)
    private List<SchedaValutazione> schedeValutazione;

    @ManyToOne
    //TODO rimettere nullable a false
    @JoinColumn(name = "id_corso", nullable = true)
    private Corso corso;

}
