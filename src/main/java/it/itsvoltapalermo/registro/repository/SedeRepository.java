package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SedeRepository extends JpaRepository<Sede, Long> {

    Optional<Sede> findByIdAndDisattivatoIsFalse(long id);
    List<Sede> findAllByDisattivatoIsFalse();
}
