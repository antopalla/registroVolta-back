package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.model.Tutor;
import it.itsvoltapalermo.registro.repository.TutorRepository;
import it.itsvoltapalermo.registro.service.def.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TutorServiceJPA implements TutorService {

    private final TutorRepository repo;

    @Override
    public void aggiungiTutor(Tutor t) {
        if(t.getId() != 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(t);

    }

    @Override
    public void modificaTutor(Tutor t) {
        if(t.getId() < 1) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(t);
    }

    @Override
    public void eliminaTutor(long id) {
        repo.delete(getTutor(id));
    }

    @Override
    public Tutor getTutor(long id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Tutor> getTutors() {
        return repo.findAll();

    }

    @Override
    public Tutor login(String username, String password) {
        return repo.findByUsernameAndPassword(username, password).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
