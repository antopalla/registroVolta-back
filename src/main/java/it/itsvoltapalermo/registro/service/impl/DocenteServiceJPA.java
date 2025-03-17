package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.model.Docente;
import it.itsvoltapalermo.registro.repository.DocenteRepository;
import it.itsvoltapalermo.registro.service.def.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DocenteServiceJPA implements DocenteService {

    private final DocenteRepository repo;

    @Override
    public void aggiungiDocente(Docente d) {
        if(d.getId() != 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(d);
    }

    @Override
    public void modificaDocente(Docente d) {
        if(d.getId() < 1) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        repo.save(d);
    }

    @Override
    public void eliminaDocente(long id) {
        Docente d = getDocente(id);
        d.setDisattivato(true);
        repo.save(d);
    }

    @Override
    public Docente getDocenteByUsername(String username) {
        return repo.findByUsernameAndDisattivatoIsFalse(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Docente getDocente(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Docente> getDocenti() {
        return repo.findAllByDisattivatoIsFalse();
    }
}
