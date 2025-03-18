package it.itsvoltapalermo.registro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.itsvoltapalermo.registro.dto.request.utenze.CambiaPasswordRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.LoginRequestDTO;
import it.itsvoltapalermo.registro.dto.response.errors.MessageDTO;
import it.itsvoltapalermo.registro.facade.AuthFacade;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.security.GestoreTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Gestione della login e cambio password")
public class AuthController {

    private final AuthFacade facade;
    private final GestoreTokenService service;

    @Operation(summary = "Login", description = "Effettua il login e restituisce il token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "OK (200)", description = "Utente trovato (all'interno dell'header troverai il token)"),
            @ApiResponse(responseCode = "NOT FOUND (404)", description = "Nessun utente con le credenziali inserite", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MessageDTO.class))),
            @ApiResponse(responseCode = "BAD REQUEST (400)", description = "Credenziali inserite non rispettano i canoni per la request", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MessageDTO.class))),
            @ApiResponse(responseCode = "I'M A TEAPOT (418)", description = "Non hai inserito il body", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MessageDTO.class))),
            @ApiResponse(responseCode = "METHOD NOT ALLOWED (405)", description = "Devi chiamare il metodo in post", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MessageDTO.class)))
    })
    @PostMapping("/login")
    public ResponseEntity<Void> login (@Valid @RequestBody LoginRequestDTO request) {
        Utente u = facade.login(request);
        return ResponseEntity.status(HttpStatus.OK).header("Authorization", service.creaTokenUtente(u)).build();
    }

    @Operation(summary = "Cambio password", description = "Cambia la password dell'utente autenticato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "OK (200)", description = "Password cambiata"),
            @ApiResponse(responseCode = "NOT FOUND (404)", description = "Nessun utente con le credenziali inserite", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MessageDTO.class))),
            @ApiResponse(responseCode = "BAD REQUEST (400)", description = "Credenziali inserite non rispettano i canoni per la request", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MessageDTO.class))),
            @ApiResponse(responseCode = "I'M A TEAPOT (418)", description = "Non hai inserito il body", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MessageDTO.class))),
            @ApiResponse(responseCode = "METHOD NOT ALLOWED (405)", description = "Devi chiamare il metodo in post", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MessageDTO.class)))
    })
    @PostMapping("/authorized/utente/cambiaPassword")
    public ResponseEntity<Void> cambiaPassword (@Valid @RequestBody CambiaPasswordRequestDTO request, UsernamePasswordAuthenticationToken upat) {
        Utente u = (Utente)upat.getPrincipal();
        facade.cambiaPassword(request, u);
        return ResponseEntity.ok().build();
    }
}
