package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.Studente;

import java.util.List;

public interface StudenteService {

    void aggiungiStudente (Studente s);
    void modificaStudente (Studente s);
    void eliminaStudente (long id);

    Studente getStudente (long id);
    List<Studente> getStudenti();

    List<Studente> getStudentiByCorso (long idCorso);
    List<Studente> getStudentiByOreAssenza (int oreAssenza);
}
