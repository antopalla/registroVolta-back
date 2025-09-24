package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Lezione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LezioneRepository extends JpaRepository<Lezione, Long> {

    Optional<Lezione> findByIdAndDisattivatoIsFalse(long id);
    List<Lezione> findAllByDisattivatoIsFalse();

    List<Lezione> findAllByDisattivatoIsFalseAndDataAndCorso_Id(LocalDate data, long corsoId);
    List<Lezione> findAllByDisattivatoIsFalseAndCorso_Id(long corsoId);

}
