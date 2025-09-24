package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.Assenza;

import java.util.List;

public interface AssenzaService {

    void aggiungiAssenza (Assenza a);

    void modificaAssenza (Assenza a);

    void eliminaAssenza (long id);

    Assenza getAssenza (long id);
    List<Assenza> getAssenze();

    List<Assenza> getAssenzeByStudente (long idStudente);

    List<Assenza> getAssenzeByLezione (long idLezione);

}
