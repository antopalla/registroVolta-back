package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.StudenteResponseDTO;
import it.itsvoltapalermo.registro.facade.StudenteFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudenteController {

    private final StudenteFacade sFacade;

    @PostMapping("/admin/studente/aggiungi")
    public ResponseEntity<Void> aggiungiStudente(@Valid @RequestBody AggiungiStudenteRequestDTO request) {

        sFacade.aggiungiStudente(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/studente/modifica")
    public ResponseEntity<Void> modificaStudente(@Valid @RequestBody ModificaStudenteRequestDTO request) {

        sFacade.modificaStudente(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/studente/elimina/{id}")
    public ResponseEntity<Void> eliminaStudente(@PathVariable long id){

        sFacade.eliminaStudente(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/studente/getStudente/{id}")
    public ResponseEntity<StudenteResponseDTO> getStudente(@PathVariable long id){

        StudenteResponseDTO sDTO = sFacade.getStudente(id);
        return ResponseEntity.ok(sDTO);
    }

    @GetMapping("/admin/studente/getAll")
    public ResponseEntity<List<StudenteResponseDTO>> getAllStudenti(){

        List<StudenteResponseDTO> sDTOList = sFacade.getAllStudenti();
        return ResponseEntity.ok(sDTOList);
    }

    @GetMapping("/docente/studente/getStudenteByClasse/{id}")
    public ResponseEntity<List<StudenteResponseDTO>> getStudentiByClasse(@PathVariable long id) {
        List<StudenteResponseDTO> sDTOList = sFacade.getStudentiByClasse(id);
        return ResponseEntity.ok(sDTOList);
    }

    @GetMapping("/tutor/studente/getStudentiByOreAssenza/{oreAssenza}")
    public ResponseEntity<List<StudenteResponseDTO>> getStudentiByOreAssenza(@PathVariable int oreAssenza) {
        List<StudenteResponseDTO> sDTOList = sFacade.getStudentiByOreAssenza(oreAssenza);
        return ResponseEntity.ok(sDTOList);
    }

}
