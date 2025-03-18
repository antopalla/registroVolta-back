package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.TutorResponseDTO;
import it.itsvoltapalermo.registro.facade.TutorFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TutorController {

    private final TutorFacade facade;

    @PostMapping("/admin/tutor/aggiungiTutor")
    public ResponseEntity<Void> aggiungiTutor (@Valid @RequestBody AggiungiTutorRequestDTO request) {
        facade.aggiungiTutor(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/tutor/aggiungiAdmin")
    public ResponseEntity<Void> aggiungiAdmin (@Valid @RequestBody AggiungiTutorRequestDTO request) {
        facade.aggiungiAdmin(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/tutor/modificaTutor")
    public ResponseEntity<Void> modificaTutor (@Valid @RequestBody ModificaTutorRequestDTO request) {
        facade.modificaTutor(request);
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
