package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.AggiungiSedeRequestDTO;
import it.itsvoltapalermo.registro.dto.request.ModificaSedeRequestDTO;
import it.itsvoltapalermo.registro.dto.response.SedeResponseDTO;
import it.itsvoltapalermo.registro.facade.SedeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SedeController {

    private final SedeFacade sFacade;

    @PostMapping("/admin/sede/registra")
    public ResponseEntity<Void> aggiungiSede(AggiungiSedeRequestDTO request){

        sFacade.aggiungiSede(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/sede/modifica")
    public ResponseEntity<Void> modificaSede(ModificaSedeRequestDTO request){

        sFacade.modificaSede(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/sede/elimina")
    public ResponseEntity<Void> eliminaSede(long id){

        sFacade.eliminaSede(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/admin/sede/getSede/{id}")
    public ResponseEntity<SedeResponseDTO> getSede(@PathVariable long id){

        SedeResponseDTO sDTO = sFacade.getSede(id);
        return ResponseEntity.ok().body(sDTO);
    }

    @GetMapping("/admin/sede/getAll")
    public ResponseEntity<List<SedeResponseDTO>> getAllSedi(){

        List<SedeResponseDTO> sDTOList = sFacade.getAllSedi();
        return ResponseEntity.ok().body(sDTOList);
    }
}
