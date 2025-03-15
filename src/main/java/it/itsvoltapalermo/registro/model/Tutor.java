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
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String cognome;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    private Ruolo ruolo;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.MERGE)
    private List<Corso> corsi;

}
