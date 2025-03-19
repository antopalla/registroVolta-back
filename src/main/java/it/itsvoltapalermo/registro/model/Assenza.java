package it.itsvoltapalermo.registro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
public class Assenza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double durata;

    @ManyToOne
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;

    @ManyToOne
    @JoinColumn(name = "id_lezione", nullable = false)
    private Lezione lezione;

    private boolean disattivato;
}
