package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    Optional<Modulo> findByIdAndDisattivatoIsFalse(long id);
    List<Modulo> findAllByDisattivatoIsFalse();
    List<Modulo> findAllByCorso_IdAndDisattivatoIsFalse(long corsoId);
}
