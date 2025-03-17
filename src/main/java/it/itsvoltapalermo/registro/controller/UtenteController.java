package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.utenze.CambiaPasswordRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.LoginRequestDTO;
import it.itsvoltapalermo.registro.facade.UtenteFacade;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.security.GestoreTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UtenteController {

    private final UtenteFacade facade;
    private final GestoreTokenService service;

    @PostMapping("/all/utente/login")
    public ResponseEntity<Void> login (@Valid @RequestBody LoginRequestDTO request) {
        Utente u = facade.login(request);
        return ResponseEntity.status(HttpStatus.OK).header("Authorization", service.creaTokenUtente(u)).build();
    }

    @PostMapping("/authorized/utente/cambiaPassword")
    public ResponseEntity<Void> cambiaPassword (@Valid @RequestBody CambiaPasswordRequestDTO request) {
        facade.cambiaPassword(request);
        return ResponseEntity.ok().build();
    }

}
