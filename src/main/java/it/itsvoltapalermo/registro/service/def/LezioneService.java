package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.Lezione;

import java.util.List;

public interface LezioneService {

    void aggiungiLezione (Lezione l);
    void modificaLezione (Lezione l);
    void eliminaLezione (long id);

    Lezione getLezione (long id);
    List<Lezione> getLezioni();

}
