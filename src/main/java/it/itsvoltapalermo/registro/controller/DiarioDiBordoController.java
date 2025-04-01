package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiDiarioRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaDiarioRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.DiarioResponseDTO;
import it.itsvoltapalermo.registro.facade.CorsoFacade;
import it.itsvoltapalermo.registro.facade.DiarioDiBordoFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DiarioDiBordoController {

    private final DiarioDiBordoFacade facade;

    @PostMapping("studente/diario/aggiungi")
    public ResponseEntity<Void> aggiungiDiario(@RequestBody @Valid AggiungiDiarioRequestDTO request){
        facade.aggiungiDiario(request);
        return ResponseEntity.ok().build();
    }
    @PostMapping("studente/diario/modifica")
    public ResponseEntity<Void> modificaDiario(@RequestBody @Valid ModificaDiarioRequestDTO request){
        facade.modificaDiario(request);
        return ResponseEntity.ok().build();
    }
    @PostMapping("admin/diario/elimina")
    public ResponseEntity<Void> eliminaDiario(@PathVariable long id){
        facade.eliminaDiario(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("admin/diario/getDiario/{id}")
    public ResponseEntity<DiarioResponseDTO> getDiario(@PathVariable long id){
        DiarioResponseDTO dto = facade.getDiario(id);
        return ResponseEntity.ok(dto);
    }
    //TODO finire controller
    /*
    @GetMapping("admin/diario/getDiari")
    public ResponseEntity<List<DiarioResponseDTO>> getAllDiari(){
        List<DiarioResponseDTO> dtoList = facade.getDiari();
        return ResponseEntity.ok(dtoList);
    }

     */
}
