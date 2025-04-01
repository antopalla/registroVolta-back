package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Pagina;
import it.itsvoltapalermo.registro.repository.PaginaRepository;
import it.itsvoltapalermo.registro.service.def.PaginaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaginaJPA implements PaginaService {

    private final PaginaRepository repo;

    @Override
    public void aggiungiPagina(Pagina m) {
        if (m.getId() != 0) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "Id non valido");
        repo.save(m);
    }

    @Override
    public void modificaPagina(Pagina m) {
        if (m.getId() <1 ) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "Id non valido");
        repo.save(m);
    }

    @Override
    public void eliminaPagina(long id) {
        Pagina m = getPagina(id);
        m.setDisattivato(true);
        repo.save(m);
    }

    @Override
    public Pagina getPagina(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Id non valido"));
    }

    @Override
    public List<Pagina> getPagineByDiario(long id) {
        return repo.findAllByDisattivatoIsFalse();
    }
}
