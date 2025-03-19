package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudenteRepository extends JpaRepository<Studente, Long> {

    Optional<Studente> findByIdAndDisattivatoIsFalse(long id);
    List<Studente> findAllByDisattivatoIsFalse();

    // TODO da aggiornare con registro. prima di prod
    @Query(value = "SELECT s.* " +
            "FROM studente s " +
            "JOIN ( " +
            "    SELECT id_studente, SUM(durata) AS totale_assenze " +
            "    FROM assenza " +
            "    GROUP BY id_studente " +
            ") a ON s.id = a.id_studente " +
            "WHERE s.disattivato = false " +
            "  AND a.totale_assenze > :oreAssenza", nativeQuery = true)
    List<Studente> findStudentiConAssenzeSuperate(@Param("oreAssenza") int oreAssenza);

    List<Studente> findAllByCorso_IdAndDisattivatoIsFalse(long id);

}
