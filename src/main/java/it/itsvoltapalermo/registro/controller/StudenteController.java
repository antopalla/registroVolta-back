package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.StudenteAssenzeResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.StudenteResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.UsernamePasswordResponseDTO;
import it.itsvoltapalermo.registro.facade.StudenteFacade;
import it.itsvoltapalermo.registro.model.Utente;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudenteController {

    //TODO creare Entity DiarioBordo

    private final StudenteFacade facade;

    @PostMapping("/admin/studente/aggiungi")
    public ResponseEntity<UsernamePasswordResponseDTO> aggiungiStudente(@Valid @RequestBody AggiungiStudenteRequestDTO request) {
        UsernamePasswordResponseDTO sDTO = facade.aggiungiStudente(request);
        return ResponseEntity.ok(sDTO);
    }

    @PostMapping("/studente/studente/modifica")
    public ResponseEntity<Void> modificaStudente(@Valid @RequestBody ModificaStudenteRequestDTO request, UsernamePasswordAuthenticationToken upat) {
        Utente u = (Utente)upat.getPrincipal();
        facade.modificaStudente(request, u);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/studente/elimina/{id}")
    public ResponseEntity<Void> eliminaStudente(@PathVariable long id){
        facade.eliminaStudente(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/studente/studente/getStudente/{id}")
    public ResponseEntity<StudenteResponseDTO> getStudente(@PathVariable long id, UsernamePasswordAuthenticationToken upat){
        Utente u = (Utente)upat.getPrincipal();
        StudenteResponseDTO sDTO = facade.getStudente(id, u);
        return ResponseEntity.ok(sDTO);
    }

    @GetMapping("/tutor/studente/getAll")
    public ResponseEntity<List<StudenteResponseDTO>> getAllStudenti(){
        List<StudenteResponseDTO> sDTOList = facade.getAllStudenti();
        return ResponseEntity.ok(sDTOList);
    }

    @GetMapping("/docente/studente/getStudenteByClasse/{id}")
    public ResponseEntity<List<StudenteResponseDTO>> getStudentiByClasse(@PathVariable long id) {
        List<StudenteResponseDTO> sDTOList = facade.getStudentiByClasse(id);
        return ResponseEntity.ok(sDTOList);
    }

    @GetMapping("/tutor/studente/getStudentiByOreAssenza/{oreAssenza}")
    public ResponseEntity<List<StudenteAssenzeResponseDTO>> getStudentiByOreAssenza(@PathVariable int oreAssenza) {
        List<StudenteAssenzeResponseDTO> sDTOList = facade.getStudentiByOreAssenza(oreAssenza);
        return ResponseEntity.ok(sDTOList);
    }

}
