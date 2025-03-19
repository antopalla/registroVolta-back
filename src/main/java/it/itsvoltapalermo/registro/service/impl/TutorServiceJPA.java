package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Tutor;
import it.itsvoltapalermo.registro.repository.TutorRepository;
import it.itsvoltapalermo.registro.service.def.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TutorServiceJPA implements TutorService {

    private final TutorRepository repo;

    @Override
    public void aggiungiTutor(Tutor t) {
        if(t.getId() != 0) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(t);

    }

    @Override
    public void modificaTutor(Tutor t) {
        if(t.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(t);
    }

    @Override
    public void eliminaTutor(long id) {
        Tutor t =  getTutor(id);
        t.setDisattivato(true);
        repo.save(t);
    }

    @Override
    public Tutor getTutor(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Tutor non trovato"));
    }

    @Override
    public List<Tutor> getTutors() {
        return repo.findAllByDisattivatoIsFalse();

    }
}
