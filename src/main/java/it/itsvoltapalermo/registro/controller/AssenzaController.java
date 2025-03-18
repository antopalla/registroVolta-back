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

    private final AssenzaFacade aFacade;

    @PostMapping("/tutor/assenza/aggiungi")
    public ResponseEntity<Void> aggiungiAssenza(@Valid @RequestBody AggiungiAssenzaRequestDTO request){
        aFacade.aggiungiAssenza(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/tutor/assenza/modifica")
    public ResponseEntity<Void> modificaAssenza(@Valid @RequestBody ModificaAssenzaRequestDTO request){
        aFacade.modificaAssenza(request);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/tutor/assenza/elimina/{id}")
    public ResponseEntity<Void> eliminaAssenza(@PathVariable long id){
        aFacade.eliminaAssenza(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/tutor/assenza/getAssenza/{id}")
    public ResponseEntity<AssenzaResponseDTO> getAssenza(@PathVariable long id){
        AssenzaResponseDTO aDTO = aFacade.getAssenza(id);

        return ResponseEntity.ok().body(aDTO);
    }

    @GetMapping("/tutor/assenza/getAll")
    public ResponseEntity<List<AssenzaResponseDTO>> getAllAssenze(){
        List<AssenzaResponseDTO> aDTOList = aFacade.getAssenze();

        return ResponseEntity.ok().body(aDTOList);
    }

}
