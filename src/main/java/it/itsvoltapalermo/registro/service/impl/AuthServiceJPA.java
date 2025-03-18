package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.repository.UtenteRepository;
import it.itsvoltapalermo.registro.service.def.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthServiceJPA implements AuthService {

    private final UtenteRepository repo;

    @Override
    public void modificaUtente(Utente u) {
        if (u.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(u);
    }

    @Override
    public Utente getUtente(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Utente non trovato"));
    }

    @Override
    public Utente getByUsername(String username) {
        return repo.findByUsernameAndDisattivatoIsFalse(username).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "username", "Utente non trovato"));
    }

    @Override
    public List<Utente> getUtenti() {
        return repo.findAllByDisattivatoIsFalse();
    }

    @Override
    public List<Utente> getUtentiByRuolo(Ruolo ruolo) {
        return repo.findAllByRuoloAndDisattivatoIsFalse(ruolo);
    }
}
