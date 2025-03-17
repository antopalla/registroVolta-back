package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.Layout;

import java.util.List;

public interface LayoutService {
    void aggiungiLayout (Layout l);
    void modificaLayout (Layout l);
    void eliminaLayout (long id);

    Layout getLayout (long id);
    List<Layout> getLayouts();
}
