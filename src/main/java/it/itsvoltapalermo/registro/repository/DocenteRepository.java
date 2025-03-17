package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Long> {

    Optional<Docente> findByIdAndDisattivatoIsFalse(long id);
    Optional<Docente> findByUsernameAndDisattivatoIsFalse(String username);

    List<Docente> findAllByDisattivatoIsFalse();
}
