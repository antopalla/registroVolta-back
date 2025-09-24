package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.Modulo;

import java.util.List;

public interface ModuloService {

    void aggiungiModulo(Modulo modulo);
    void modificaModulo(Modulo modulo);
    void eliminaModulo(long id);

    Modulo getModulo(long id);
    List<Modulo> getModuli();
    List<Modulo> getModuliByDocente(long idDocente);
    List<Modulo> getModuliByCorso(long idCorso);


}
