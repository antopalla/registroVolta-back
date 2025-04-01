package it.itsvoltapalermo.registro.service.def;


import it.itsvoltapalermo.registro.model.Pagina;

import java.util.List;

public interface PaginaService {

    void aggiungiPagina(Pagina m);
    void modificaPagina(Pagina m);
    void eliminaPagina(long id);

    Pagina getPagina(long id);
    List<Pagina> getPagineByDiario(long id);

}
