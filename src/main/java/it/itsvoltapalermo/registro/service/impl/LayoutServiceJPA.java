package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Layout;
import it.itsvoltapalermo.registro.repository.LayoutRepository;
import it.itsvoltapalermo.registro.service.def.LayoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LayoutServiceJPA implements LayoutService {

    private final LayoutRepository repo;

    @Override
    public void aggiungiLayout(Layout l) {
        if(l.getId() != 0) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(l);
    }

    @Override
    public void modificaLayout(Layout l) {
        if(l.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(l);
    }

    @Override
    public void eliminaLayout(long id) {
        Layout l = getLayout(id);
        l.setDisattivato(true);
        repo.save(l);
    }

    @Override
    public Layout getLayout(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Layout non trovato"));
    }

    @Override
    public List<Layout> getLayouts() {
        return repo.findAllByDisattivatoIsFalse();
    }
}
