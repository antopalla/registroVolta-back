package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.DocenteResponseDTO;
import it.itsvoltapalermo.registro.facade.DocenteFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DocenteController {

    private final DocenteFacade facade;

    @PostMapping("/admin/docente/aggiungiDocente")
    public ResponseEntity<Void> aggiungiDocente (@Valid @RequestBody AggiungiDocenteRequestDTO request) {
        facade.aggiungiDocente(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/docente/aggiungiAdmin")
    public ResponseEntity<Void> aggiungiAdmin (@Valid @RequestBody AggiungiDocenteRequestDTO request) {
        facade.aggiungiAdmin(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/docente/modificaDocente")
    public ResponseEntity<Void> modificaDocente (@Valid @RequestBody ModificaDocenteRequestDTO request) {
        facade.modificaDocente(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/docente/eliminaDocente/{id}")
    public ResponseEntity<Void> eliminaDocente (@PathVariable long id) {
        facade.eliminaDocente(id);
        return ResponseEntity.ok().build();
    }

    //TODO Modificare con security
    @GetMapping("/Docente/docente/getDocente/{id}")
    public ResponseEntity<DocenteResponseDTO> getDocente (@PathVariable long id) {
        DocenteResponseDTO tDTO = facade.getDocente(id);
        return ResponseEntity.ok(tDTO);
    }

    @GetMapping("/admin/docente/getAll")
    public ResponseEntity<List<DocenteResponseDTO>> getAllDocente () {
        List<DocenteResponseDTO> tDTO = facade.getDocenti();
        return ResponseEntity.ok(tDTO);
    }
}
