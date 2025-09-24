package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Docente;
import it.itsvoltapalermo.registro.repository.DocenteRepository;
import it.itsvoltapalermo.registro.service.def.DocenteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DocenteServiceJPA implements DocenteService {

    private final DocenteRepository repo;

    @Override
    public void aggiungiDocente(Docente d) {
        if(d.getId() != 0) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(d);
    }

    @Transactional
    @Override
    public void modificaDocente(Docente d) {
        if(d.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(d);
    }

    @Override
    public void eliminaDocente(long id) {
        Docente d = getDocente(id);
        d.setDisattivato(true);
        repo.save(d);
    }

    @Transactional
    @Override
    public Docente getDocenteByUsername(String username) {
        return repo.findByUsernameAndDisattivatoIsFalse(username).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "username", "Docente non trovato"));
    }

    @Transactional
    @Override
    public Docente getDocente(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Docente non trovato"));
    }

    @Transactional
    @Override
    public List<Docente> getDocenti() {
        return repo.findAllByDisattivatoIsFalse();
    }

}
