package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.Sede;

import java.util.List;

public interface SedeService {

    void aggiungiSede (Sede s);
    void modificaSede (Sede s);
    void eliminaSede (long id);

    Sede getSede (long id);
    List<Sede> getSedi();

}
