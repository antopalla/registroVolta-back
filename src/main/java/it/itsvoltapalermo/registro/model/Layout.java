package it.itsvoltapalermo.registro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
public class Layout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String descrizione;

    private String path;
    private LocalDateTime dataCreazione;

    @OneToMany(mappedBy = "layout", cascade = CascadeType.MERGE)
    private List<SchedaValutazione> schedeValutazione;

    private boolean disattivato;
}
