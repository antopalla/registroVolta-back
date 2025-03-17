package it.itsvoltapalermo.registro.repository;

import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Optional<Utente> findByIdAndDisattivatoIsFalse(long id);
    Optional<Utente> findByUsernameAndDisattivatoIsFalse(String username);
    Optional<Utente> findByUsernameAndPasswordAndDisattivatoIsFalse(String username, String password);
    List<Utente> findAllByRuoloAndDisattivatoIsFalse(Ruolo r);
    List<Utente> findAllByDisattivatoIsFalse();

}
