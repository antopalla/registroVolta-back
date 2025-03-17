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
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String indirizzo;
    private String citta;
    private String cap;

    @OneToMany(mappedBy = "sede", cascade = CascadeType.MERGE)
    private List<Corso> corsi;

    private boolean disattivato;
}
