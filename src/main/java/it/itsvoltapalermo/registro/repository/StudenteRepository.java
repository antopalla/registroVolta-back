package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudenteRepository extends JpaRepository<Studente, Long> {

    Optional<Studente> findByIdAndDisattivatoIsFalse(long id);

    List<Studente> findAllByDisattivatoIsFalse();

    //TODO Inserire disattivato is false nella query
    @Query(value = "SELECT s.* " +
            "FROM registro.studente s " +
            "JOIN registro.assenza a ON s.id = a.id_studente " +
            "GROUP BY s.id, s.nome, s.cognome " +
            "HAVING SUM(EXTRACT(EPOCH FROM (a.durata - TIME '00:00:00'))) / 3600 > ?1",
            nativeQuery = true)
    List<Studente> findStudentiConAssenzeSuperate(int oreAssenza);

    List<Studente> findAllByCorso_IdAndDIsattivatoIsFalse(long id);

}
