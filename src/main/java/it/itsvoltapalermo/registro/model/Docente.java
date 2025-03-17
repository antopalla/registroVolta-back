package it.itsvoltapalermo.registro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@DiscriminatorValue("DOCENTE")
public class Docente extends Utente {

    private LocalDate dataNascita;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.MERGE)
    private List<Lezione> lezioni;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.MERGE)
    private List<Modulo> moduli;


}
