package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.Tutor;

import java.util.List;

public interface TutorService {
    void aggiungiTutor (Tutor t);
    void modificaTutor (Tutor t);
    void eliminaTutor (long id);

    Tutor getTutor (long id);
    List<Tutor> getTutors();

}
