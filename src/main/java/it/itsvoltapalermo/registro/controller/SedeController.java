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

    private final SedeFacade facade;

    @PostMapping("/admin/sede/aggiungi")
    public ResponseEntity<Void> aggiungiSede(@Valid @RequestBody AggiungiSedeRequestDTO request){
        facade.aggiungiSede(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/sede/modifica")
    public ResponseEntity<Void> modificaSede(@Valid @RequestBody ModificaSedeRequestDTO request){
        facade.modificaSede(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/sede/elimina/{id}")
    public ResponseEntity<Void> eliminaSede(@PathVariable long id){
        facade.eliminaSede(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/sede/getSede/{id}")
    public ResponseEntity<SedeResponseDTO> getSede(@PathVariable long id){
        SedeResponseDTO sDTO = facade.getSede(id);
        return ResponseEntity.ok().body(sDTO);
    }

    @GetMapping("/docente/sede/getAll")
    public ResponseEntity<List<SedeResponseDTO>> getAllSedi(){
        List<SedeResponseDTO> sDTOList = facade.getAllSedi();
        return ResponseEntity.ok().body(sDTOList);
    }
}
