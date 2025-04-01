package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.DiarioDiBordo;
import it.itsvoltapalermo.registro.repository.DiarioDiBordoRepository;
import it.itsvoltapalermo.registro.service.def.DiarioDiBordoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DarioDiBordoJPA implements DiarioDiBordoService {

    private final DiarioDiBordoRepository repo;

    @Override
    public void aggiungiDiario(DiarioDiBordo d) {
        if (d.getId() != 0) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "Id", "Id non valido");
        repo.save(d);
    }

    @Override
    public void modificaDiario(DiarioDiBordo d) {
        if (d.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "Id", "Id non valido");
        repo.save(d);
    }

    @Override
    public void eliminaDiario(long id) {
        DiarioDiBordo d = getDiario(id);
        d.setDisattivato(true);
        repo.save(d);
    }

    @Override
    public DiarioDiBordo getDiario(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "Id", "Id non valido"));
    }

    @Override
    public List<DiarioDiBordo> getDiarioByStudente() {
        return repo.findAllByDisattivatoIsFalse();
    }
}
