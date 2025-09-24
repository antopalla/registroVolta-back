package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Assenza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssenzaRepository extends JpaRepository<Assenza, Long> {

    Optional<Assenza> findByIdAndDisattivatoIsFalse(long id);

    List<Assenza> findAllByDisattivatoIsFalse();
    List<Assenza> findAllByStudente_IdAndDisattivatoIsFalse(long idStudente);
    List<Assenza> findAllByLezione_IdAndDisattivatoIsFalse(long idLezione);
}
