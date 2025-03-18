package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Corso;
import it.itsvoltapalermo.registro.repository.CorsoRepository;
import it.itsvoltapalermo.registro.service.def.CorsoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CorsoServiceJPA implements CorsoService {

    private final CorsoRepository repo;

    @Override
    public void aggiungiCorso(Corso c) {
        if (c.getId() != 0) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(c);
    }

    @Override
    public void modificaCorso(Corso c) {
        if (c.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(c);
    }

    @Override
    public void eliminaCorso(long id) {
        Corso c = getCorso(id);
        c.setDisattivato(true);
        repo.save(c);
    }

    @Override
    public Corso getCorso(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Corso non trovato"));
    }

    @Override
    public List<Corso> getCorsi() {
        return repo.findAllByDisattivatoIsFalse();
    }
}
