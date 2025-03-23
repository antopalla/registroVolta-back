package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.TutorResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.UsernamePasswordResponseDTO;
import it.itsvoltapalermo.registro.facade.TutorFacade;
import it.itsvoltapalermo.registro.model.Utente;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TutorController {

    private final TutorFacade facade;

    @PostMapping("/admin/tutor/aggiungiTutor")
    public ResponseEntity<UsernamePasswordResponseDTO> aggiungiTutor (@Valid @RequestBody AggiungiTutorRequestDTO request) {
        UsernamePasswordResponseDTO tDTO = facade.aggiungiTutor(request);
        return ResponseEntity.ok(tDTO);
    }

    @PostMapping("/admin/tutor/aggiungiAdmin")
    public ResponseEntity<Void> aggiungiAdmin (@Valid @RequestBody AggiungiTutorRequestDTO request) {
        facade.aggiungiAdmin(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tutor/tutor/modificaTutor")
    public ResponseEntity<Void> modificaTutor (@Valid @RequestBody ModificaTutorRequestDTO request, UsernamePasswordAuthenticationToken upat) {
        Utente u = (Utente)upat.getPrincipal();
        facade.modificaTutor(request, u);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/tutor/eliminaTutor/{id}")
    public ResponseEntity<Void> eliminaTutor (@PathVariable long id) {
        facade.eliminaTutor(id);
        return ResponseEntity.ok().build();
    }

    //TODO Modificare con security
    @GetMapping("/tutor/tutor/getTutor/{id}")
    public ResponseEntity<TutorResponseDTO> getTutor (@PathVariable long id) {
        TutorResponseDTO tDTO = facade.getTutor(id);
        return ResponseEntity.ok(tDTO);
    }

    @GetMapping("/admin/tutor/getAll")
    public ResponseEntity<List<TutorResponseDTO>> getAllTutor () {
        List<TutorResponseDTO> tDTO = facade.getTutors();
        return ResponseEntity.ok(tDTO);
    }
}
