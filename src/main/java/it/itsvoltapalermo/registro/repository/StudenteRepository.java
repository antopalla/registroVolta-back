package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente, Long> {

}
