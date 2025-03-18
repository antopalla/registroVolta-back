package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.governance.AggiungiSedeRequestDTO;
import it.itsvoltapalermo.registro.dto.request.governance.ModificaSedeRequestDTO;
import it.itsvoltapalermo.registro.dto.response.governance.SedeResponseDTO;
import it.itsvoltapalermo.registro.facade.SedeFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SedeController {

    private final SedeFacade sFacade;

    @PostMapping("/admin/sede/aggiungi")
    public ResponseEntity<Void> aggiungiSede(@Valid @RequestBody AggiungiSedeRequestDTO request){

        sFacade.aggiungiSede(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/sede/modifica")
    public ResponseEntity<Void> modificaSede(@Valid @RequestBody ModificaSedeRequestDTO request){

        sFacade.modificaSede(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/sede/elimina/{id}")
    public ResponseEntity<Void> eliminaSede(@PathVariable long id){

        sFacade.eliminaSede(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/sede/getSede/{id}")
    public ResponseEntity<SedeResponseDTO> getSede(@PathVariable long id){

        SedeResponseDTO sDTO = sFacade.getSede(id);
        return ResponseEntity.ok().body(sDTO);
    }

    @GetMapping("/docente/sede/getAll")
    public ResponseEntity<List<SedeResponseDTO>> getAllSedi(){

        List<SedeResponseDTO> sDTOList = sFacade.getAllSedi();
        return ResponseEntity.ok().body(sDTOList);
    }
}
