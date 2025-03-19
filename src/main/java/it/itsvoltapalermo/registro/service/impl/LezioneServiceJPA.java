package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Lezione;
import it.itsvoltapalermo.registro.repository.LezioneRepository;
import it.itsvoltapalermo.registro.service.def.LezioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LezioneServiceJPA implements LezioneService {

    private final LezioneRepository repo;
    @Override
    public void aggiungiLezione(Lezione l) {
        if(l.getId() != 0) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(l);
    }

    @Override
    public void modificaLezione(Lezione l) {
        if(l.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(l);

    }

    @Override
    public void eliminaLezione(long id) {
        Lezione l = getLezione(id);
        l.setDisattivato(true);
        repo.save(l);
    }

    @Override
    public Lezione getLezione(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Lezione non trovata"));
    }

    @Override
    public List<Lezione> getLezioni() {
        return repo.findAllByDisattivatoIsFalse();
    }
}
