package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.SchedaValutazione;

import java.util.List;

public interface SchedaValutazioneService {
    void aggiungiSchedaValutazione (SchedaValutazione s);
    void modificaSchedaValutazione (SchedaValutazione s);
    void eliminaSchedaValutazione (long id);



    SchedaValutazione getSchedaValutazione (long id);
    List<SchedaValutazione> getSchedeValutazione();
    byte[] generaExcel(SchedaValutazione scheda);
}
