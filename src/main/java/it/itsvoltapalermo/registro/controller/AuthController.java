package it.itsvoltapalermo.registro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.itsvoltapalermo.registro.dto.request.utenze.CambiaPasswordRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.LoginRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.UtenteResponseDTO;
import it.itsvoltapalermo.registro.facade.AuthFacade;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.security.GestoreTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Gestione della login e cambio password")
public class AuthController {

    private final AuthFacade facade;
    private final GestoreTokenService service;

    @Operation(summary = "Login", description = "Effettua il login e restituisce il token")
    @PostMapping("/login")
    public ResponseEntity<Void> login (@Valid @RequestBody LoginRequestDTO request) {
        Utente u = facade.login(request);
        return ResponseEntity.status(HttpStatus.OK).header("Authorization", service.creaTokenUtente(u)).build();
    }

    @Operation(summary = "Cambio password", description = "Cambia la password dell'utente autenticato")
    @PostMapping("/authorized/utente/cambiaPassword")
    public ResponseEntity<Void> cambiaPassword (@Valid @RequestBody CambiaPasswordRequestDTO request, UsernamePasswordAuthenticationToken upat) {
        Utente u = (Utente)upat.getPrincipal();
        facade.cambiaPassword(request, u);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/authorized/utente/getUtente")
    public ResponseEntity<UtenteResponseDTO> getDocente (UsernamePasswordAuthenticationToken upat) {
        UtenteResponseDTO uDTO = facade.getUtente((Utente)upat.getPrincipal());
        return ResponseEntity.ok(uDTO);
    }
}
