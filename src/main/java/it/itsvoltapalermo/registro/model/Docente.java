package it.itsvoltapalermo.registro.model;

import it.itsvoltapalermo.registro.converters.ImageEncryptorConverter;
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
@DiscriminatorValue("Docente")
public class Docente extends Utente {

    @Lob
    @Convert(converter = ImageEncryptorConverter.class)
    private byte[] immagineFirma;
  
    @OneToMany(mappedBy = "docente", cascade = CascadeType.MERGE)
    private List<Lezione> lezioni;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.MERGE)
    private List<Modulo> moduli;
}
