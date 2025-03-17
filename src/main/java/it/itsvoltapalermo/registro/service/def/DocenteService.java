package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.Docente;

import java.util.List;

public interface DocenteService {
    void aggiungiDocente (Docente d);
    void modificaDocente (Docente d);
    void eliminaDocente (long id);

    Docente getDocenteByUsername(String username);
    Docente getDocente (long id);
    List<Docente> getDocenti();
}
