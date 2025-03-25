package it.itsvoltapalermo.registro.repository;


import it.itsvoltapalermo.registro.model.DiarioDiBordo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiarioDiBordoRepository extends JpaRepository<DiarioDiBordo, Long> {

    Optional<DiarioDiBordo> findByIdAndDisattivatoIsFalse(long id);
    List<DiarioDiBordo> findAllByDisattivatoIsFalse();

}
