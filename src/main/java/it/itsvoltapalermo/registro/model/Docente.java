package it.itsvoltapalermo.registro.model;

import it.itsvoltapalermo.registro.converters.ImageEncryptorConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@DiscriminatorValue("Docente")
public class Docente extends Utente {

    @Lob
    @Column(length = 65535)
    @JdbcTypeCode(SqlTypes.VARBINARY)
    @Convert(converter = ImageEncryptorConverter.class)
    private byte[] immagineFirma;
  
    @OneToMany(mappedBy = "docente", cascade = CascadeType.MERGE)
    private List<Lezione> lezioni;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.MERGE)
    private List<Modulo> moduli;
}
