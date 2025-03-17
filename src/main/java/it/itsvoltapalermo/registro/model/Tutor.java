package it.itsvoltapalermo.registro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@DiscriminatorValue("TUTOR")
public class Tutor extends Utente {

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.MERGE)
    private List<Corso> corsi;
}
