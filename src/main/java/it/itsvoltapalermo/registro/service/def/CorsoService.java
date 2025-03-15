package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.Corso;

import java.util.List;

public interface CorsoService {

    void aggiungiCorso (Corso c);
    void modificaCorso (Corso c);
    void eliminaCorso (long id);

    Corso getCorso (long id);
    List<Corso> getCorsi();

}
