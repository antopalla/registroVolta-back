package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CorsoRepository extends JpaRepository<Corso, Long> {

    Optional<Corso> findByIdAndDisattivatoIsFalse(long id);
    List<Corso> findAllByDisattivatoIsFalse();

}
