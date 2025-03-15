package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.model.Assenza;
import it.itsvoltapalermo.registro.repository.AssenzaRepository;
import it.itsvoltapalermo.registro.service.def.AssenzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssenzaServiceJPA implements AssenzaService {

    private final AssenzaRepository repo;
    @Override
    public void aggiungiAssenza(Assenza a) {
        if (a.getId() != 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(a);
    }

    @Override
    public void modificaAssenza(Assenza a) {
        if (a.getId() < 1) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(a);
    }

    @Override
    public void eliminaAssenza(long id) {
        repo.delete(getAssenza(id));
    }

    @Override
    public Assenza getAssenza(long id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Assenza> getAssenze() {
        return repo.findAll();
    }

    @Override
    public List<Assenza> getAssenzeByStudente(long idStudente) {
        return repo.findAllByStudente_Id(idStudente);
    }
}
