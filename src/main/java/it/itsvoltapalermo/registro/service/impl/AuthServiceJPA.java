package it.itsvoltapalermo.registro.service.impl;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.repository.UtenteRepository;
import it.itsvoltapalermo.registro.service.def.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthServiceJPA implements AuthService {

    private final UtenteRepository repo;
    private final UtenteRepository utenteRepository;

    @Override
    public void modificaUtente(Utente u) {
        if (u.getId() < 1) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "id", "id non valido");
        repo.save(u);
    }

    @Override
    public Utente getUtente(long id) {
        return repo.findByIdAndDisattivatoIsFalse(id).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "id", "Utente non trovato"));
    }

    @Override
    public Utente getByUsername(String username) {
        return repo.findByUsernameAndDisattivatoIsFalse(username).orElseThrow(() -> new CustomResponseStatusException(HttpStatus.NOT_FOUND, "username", "Utente non trovato"));
    }

    @Override
    public List<Utente> getUtenti() {
        return repo.findAllByDisattivatoIsFalse();
    }

    @Override
    public List<Utente> getUtentiByRuolo(Ruolo ruolo) {
        return repo.findAllByRuoloAndDisattivatoIsFalse(ruolo);
    }

    @Override
    public String setUsernameStd(String nome, String cognome) {
        String nomeLowerCase = nome.trim().toLowerCase();
        String cognomeLowerCase = cognome.trim().toLowerCase().replaceAll("[^a-z]", "");;
        String username = nomeLowerCase.charAt(0) + "." + cognomeLowerCase;

        int counter = 1;
        String usernameNuovo = username;
        while (utenteRepository.existsByUsername(usernameNuovo)) {
            usernameNuovo = username + counter;
            counter++;
        }
        return username;
    }

    @Override
    public String generaPasswordSicura() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "!@#$%&*";
        String allChars = upper + lower + digits + symbols;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(symbols.charAt(random.nextInt(symbols.length())));

        for (int i = 4; i < 10; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        List<Character> chars = password.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(ArrayList::new));

        Collections.shuffle(chars, random);

        return chars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

}
