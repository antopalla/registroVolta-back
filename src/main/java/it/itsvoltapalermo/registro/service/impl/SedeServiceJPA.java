package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.model.Sede;
import it.itsvoltapalermo.registro.repository.SedeRepository;
import it.itsvoltapalermo.registro.service.def.SedeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SedeServiceJPA implements SedeService {

    private final SedeRepository repo;

    @Override
    public void aggiungiSede(Sede s) {
        if(s.getId() != 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(s);
    }

    @Override
    public void modificaSede(Sede s) {
        if(s.getId() < 1) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @Override
    public void eliminaSede(long id) {
        Sede s = getSede(id);
        s.setDisattivato(true);
        repo.save(s);
    }

    @Override
    public Sede getSede(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Sede> getSedi() {
        return repo.findAllByDisattivatoIsFalse();
    }
}
