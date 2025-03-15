package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Assenza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssenzaRepository extends JpaRepository<Assenza, Long> {

    List<Assenza> findAllByStudente_Id(long id);
}
