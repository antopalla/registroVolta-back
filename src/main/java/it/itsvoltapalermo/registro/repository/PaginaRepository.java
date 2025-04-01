package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Pagina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaginaRepository extends JpaRepository<Pagina, Long> {

    Optional<Pagina> findByIdAndDisattivatoIsFalse(long id);
    List<Pagina> findAllByDisattivatoIsFalse();
    //TODO decidere se implementare un metodo del genere
    // List<MonitoraggioSettimana> findByDiarioDiBordoIdAndDisattivatoIsFalse(long id);

}
