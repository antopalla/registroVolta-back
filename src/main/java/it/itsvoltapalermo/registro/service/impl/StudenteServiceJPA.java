package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Studente;
import it.itsvoltapalermo.registro.repository.StudenteRepository;
import it.itsvoltapalermo.registro.service.def.StudenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StudenteServiceJPA implements StudenteService {

    private final StudenteRepository repo;

    @Override
    public void aggiungiStudente(Studente s) {
        if (s.getId() != 0) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(s);
    }

    @Override
    public void modificaStudente(Studente s) {
        if (s.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(s);
    }

    @Override
    public void eliminaStudente(long id) {
        Studente s = getStudente(id);
        s.setDisattivato(true);
        repo.save(s);
    }

    @Override
    public Studente getStudente(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Studente non trovato"));

    }

    @Override
    public List<Studente> getStudenti() {
        return repo.findAllByDisattivatoIsFalse();
    }

    @Override
    public List<Studente> getStudentiByCorso(long idCorso) {
        return repo.findAllByCorso_IdAndDisattivatoIsFalse(idCorso);

    }

    @Override
    public List<Studente> getStudentiByOreAssenza(int oreAssenza) {
        return repo.findStudentiConAssenzeSuperate(oreAssenza);
    }

}
