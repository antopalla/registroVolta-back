package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.DiarioDiBordo;
import java.util.List;

public interface DiarioDiBordoService{

    void aggiungiDiario (DiarioDiBordo d);
    void modificaDiario (DiarioDiBordo d);
    void eliminaDiario (long id);

    DiarioDiBordo getDiario (long id);
    List<DiarioDiBordo> getDiarioByStudente();
}
