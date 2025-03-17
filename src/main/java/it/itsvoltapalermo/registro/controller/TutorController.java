package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.CambiaPasswordRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.LoginRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.TutorResponseDTO;
import it.itsvoltapalermo.registro.facade.TutorFacade;
import it.itsvoltapalermo.registro.mapper.TutorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TutorController {

    private final TutorFacade facade;
    private final TutorMapper mapper;

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

    @PostMapping("/all/tutor/login")
    public ResponseEntity<Void> login (@Valid @RequestBody LoginRequestDTO request) {
        facade.login(request);
        return ResponseEntity.ok().build(); //aggiungere security
    }

    @PostMapping("/authorized/tutor/cambiaPassword")
    public ResponseEntity<Void> cambiaPassword (@Valid @RequestBody CambiaPasswordRequestDTO request) {
        facade.cambiaPassword(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/tutor/eliminaTutor/{id}")
    public ResponseEntity<Void> eliminaTutor (@PathVariable long id) {
        facade.eliminaTutor(id);
        return ResponseEntity.ok().build();
    }

    //TODO Modificare con security
    @GetMapping("/authorized/tutor/getTutor/{id}")
    public ResponseEntity<TutorResponseDTO> getTutor (@PathVariable long id) {
        TutorResponseDTO tDTO = facade.getTutor(id);
        return ResponseEntity.ok(tDTO);
    }

    @GetMapping("/admin/tutor/getAllTutor")
    public ResponseEntity<List<TutorResponseDTO>> getAllTutor () {
        List<TutorResponseDTO> tDTO = facade.getAllTutor();
        return ResponseEntity.ok(tDTO);
    }
}
