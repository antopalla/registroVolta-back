package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiAssenzaRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaAssenzaRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.AssenzaResponseDTO;
import it.itsvoltapalermo.registro.facade.AssenzaFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AssenzaController {

    private final AssenzaFacade facade;

    @PostMapping("/tutor/assenza/aggiungi")
    public ResponseEntity<Void> aggiungiAssenza(@Valid @RequestBody AggiungiAssenzaRequestDTO request){
        facade.aggiungiAssenza(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tutor/assenza/modifica")
    public ResponseEntity<Void> modificaAssenza(@Valid @RequestBody ModificaAssenzaRequestDTO request){
        facade.modificaAssenza(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/tutor/assenza/elimina/{id}")
    public ResponseEntity<Void> eliminaAssenza(@PathVariable long id){
        facade.eliminaAssenza(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tutor/assenza/getAssenza/{id}")
    public ResponseEntity<AssenzaResponseDTO> getAssenza(@PathVariable long id){
        AssenzaResponseDTO aDTO = facade.getAssenza(id);
        return ResponseEntity.ok().body(aDTO);
    }

    @GetMapping("/tutor/assenza/getAll")
    public ResponseEntity<List<AssenzaResponseDTO>> getAllAssenze(){
        List<AssenzaResponseDTO> aDTOList = facade.getAssenze();
        return ResponseEntity.ok().body(aDTOList);
    }

    @GetMapping("/tutor/assenza/getAssenzeByStudente/{idStudente}")
    public ResponseEntity<List<AssenzaResponseDTO>> getAssenzeByStudente(@PathVariable long idStudente){
        List<AssenzaResponseDTO> aDTOList = facade.getAssenzeByStudente(idStudente);
        return ResponseEntity.ok().body(aDTOList);
    }

    @GetMapping("/tutor/assenza/getAssenzeByLezione/{idLezione}")
    public ResponseEntity<List<AssenzaResponseDTO>> getAssenzeByLezione(@PathVariable long idLezione){
        List<AssenzaResponseDTO> aDTOList = facade.getAssenzeByLezione(idLezione);
        return ResponseEntity.ok().body(aDTOList);
    }
}
