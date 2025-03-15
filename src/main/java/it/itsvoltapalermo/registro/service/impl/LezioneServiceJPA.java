package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.model.Lezione;
import it.itsvoltapalermo.registro.repository.LezioneRepository;
import it.itsvoltapalermo.registro.service.def.LezioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LezioneServiceJPA implements LezioneService {

    private final LezioneRepository repo;
    @Override
    public void aggiungiLezione(Lezione l) {
        if(l.getId() != 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(l);
    }

    @Override
    public void modificaLezione(Lezione l) {
        if(l.getId() < 1) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(l);

    }

    @Override
    public void eliminaLezione(long id) {
        repo.delete(getLezione(id));
    }

    @Override
    public Lezione getLezione(long id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Lezione> getLezioni() {
        return repo.findAll();
    }
}
