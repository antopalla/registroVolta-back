package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Modulo;
import it.itsvoltapalermo.registro.repository.ModuloRepository;
import it.itsvoltapalermo.registro.service.def.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModuloServiceJPA implements ModuloService {

    private final ModuloRepository repo;

    @Override
    public void aggiungiModulo(Modulo m) {
        if (m.getId() != 0) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(m);
    }

    @Override
    public void modificaModulo(Modulo m) {
        if (m.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(m);
    }

    @Override
    public void eliminaModulo(long id) {
        Modulo m = getModulo(id);
        m.setDisattivato(true);
        repo.save(m);
    }

    @Override
    public Modulo getModulo(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id)
                .orElseThrow(()-> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Modulo non trovato"));
    }

    @Override
    public List<Modulo> getModuli() {
        return repo.findAllByDisattivatoIsFalse();
    }

    @Override
    public List<Modulo> getModuliByCorso(long idCorso) {
        return repo.findAllByCorso_IdAndDisattivatoIsFalse(idCorso);
    }
}
