package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.governance.AggiungiCorsoRequestDTO;
import it.itsvoltapalermo.registro.dto.request.governance.ModificaCorsoRequestDTO;
import it.itsvoltapalermo.registro.dto.response.governance.CorsoResponseDTO;
import it.itsvoltapalermo.registro.facade.CorsoFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CorsoController {

    private final CorsoFacade facade;

    @PostMapping("/admin/corso/aggiungi")
    public ResponseEntity<Void> aggiungiCorso(@Valid @RequestBody AggiungiCorsoRequestDTO request){
        facade.aggiungiCorso(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/corso/modifica")
    public ResponseEntity<Void> modificaCorso(@Valid @RequestBody ModificaCorsoRequestDTO request){
        facade.modificaCorso(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/corso/elimina/{id}")
    public ResponseEntity<Void> eliminaCorso(@PathVariable long id){
        facade.eliminaCorso(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/corso/getCorso/{id}")
    public ResponseEntity<CorsoResponseDTO> getCorso(@PathVariable long id){
        CorsoResponseDTO cDTO = facade.getCorso(id);
        return ResponseEntity.ok().body(cDTO);
    }

    @GetMapping("/docente/corso/getAll")
    public ResponseEntity<List<CorsoResponseDTO>> getAllCorsi(){
        List<CorsoResponseDTO> cDTOList = facade.getCorsi();
        return ResponseEntity.ok().body(cDTOList);
    }
}
