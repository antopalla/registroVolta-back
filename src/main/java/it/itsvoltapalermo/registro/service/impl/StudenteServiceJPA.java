package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.model.Studente;
import it.itsvoltapalermo.registro.repository.StudenteRepository;
import it.itsvoltapalermo.registro.service.def.StudenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudenteServiceJPA implements StudenteService {

    private final StudenteRepository repo;

    @Override
    public void aggiungiStudente(Studente s) {
        if(s.getId() != 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(s);
    }

    @Override
    public void modificaStudente(Studente s) {
        if(s.getId() < 1) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(s);
    }

    @Override
    public void eliminaStudente(long id) {
        repo.delete(getStudente(id));
    }

    @Override
    public Studente getStudente(long id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    @Override
    public List<Studente> getStudenti() {
        return repo.findAll();
    }

    @Override
    public List<Studente> getStudentiByCorso(long idCorso) {
        return repo.findAllByCorso_Id(idCorso);

    }
    @Override
    public List<Studente> getStudentiByOreAssenza(int oreAssenza) {
        return repo.findStudentiConAssenzeSuperate(oreAssenza);
    }
}
