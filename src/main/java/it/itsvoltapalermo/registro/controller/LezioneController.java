package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiLezioneRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaLezioneRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.LezioneResponseDTO;
import it.itsvoltapalermo.registro.facade.LezioneFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LezioneController {
    
    private final LezioneFacade lFacade;

    @PostMapping("/docente/lezione/aggiungi")
    public ResponseEntity<Void> aggiungiLezione(@Valid @RequestBody AggiungiLezioneRequestDTO request) {
        lFacade.aggiungiLezione(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/docente/lezione/modifica")
    public ResponseEntity<Void> modificaLezione(@Valid @RequestBody ModificaLezioneRequestDTO request) {
        lFacade.modificaLezione(request);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/docente/lezione/elimina/{id}")
    public ResponseEntity<Void> eliminaLezione(@PathVariable long id) {
        lFacade.eliminaLezione(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/lezione/getLezione/{id}")
    public ResponseEntity<LezioneResponseDTO> getLezione(@PathVariable long id) {
        LezioneResponseDTO lDTO = lFacade.getLezione(id);

        return ResponseEntity.ok().body(lDTO);
    }

    @GetMapping("/tutor/lezione/getAll")
    public ResponseEntity<List<LezioneResponseDTO>> getAllLezioni() {
        List<LezioneResponseDTO> lDTOList = lFacade.getAllLezioni();

        return ResponseEntity.ok().body(lDTOList);
    }

}
