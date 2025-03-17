package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.SchedaValutazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SchedaValutazioneRepository extends JpaRepository<SchedaValutazione, Long> {

    Optional<SchedaValutazione> findByIdAndDisattivatoIsFalse(long id);
    List<SchedaValutazione> findAllByDisattivatoIsFalse();

}
