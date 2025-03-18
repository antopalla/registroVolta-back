package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.utenze.CambiaPasswordRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.LoginRequestDTO;
import it.itsvoltapalermo.registro.facade.AuthFacade;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.security.GestoreTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthFacade facade;
    private final GestoreTokenService service;

    @PostMapping("/login")
    public ResponseEntity<Void> login (@Valid @RequestBody LoginRequestDTO request) {
        Utente u = facade.login(request);
        return ResponseEntity.status(HttpStatus.OK).header("Authorization", service.creaTokenUtente(u)).build();
    }

    @PostMapping("/authorized/utente/cambiaPassword")
    public ResponseEntity<Void> cambiaPassword (@Valid @RequestBody CambiaPasswordRequestDTO request, UsernamePasswordAuthenticationToken upat) {
        Utente u = (Utente)upat.getPrincipal();
        facade.cambiaPassword(request, u);
        return ResponseEntity.ok().build();
    }
}
