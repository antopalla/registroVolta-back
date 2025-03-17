package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Layout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LayoutRepository extends JpaRepository<Layout, Long> {

    Optional<Layout> findByIdAndDisattivatoIsFalse(long id);
    List<Layout> findAllByDisattivatoIsFalse();

}
