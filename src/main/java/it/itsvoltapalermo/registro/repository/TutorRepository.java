package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    Optional<Tutor> findByUsernameAndPassword(String username, String password);
}
