package it.itsvoltapalermo.registro.service.def;

import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Utente;

import java.util.List;

public interface UtenteService {

    void modificaUtente(Utente u);
    Utente getUtente (long id);
    Utente getByUsername (String username);
    Utente login (String username, String password);

    List<Utente> getUtenti();
    List<Utente> getUtentiByRuolo (Ruolo ruolo);
}
