package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiModuloRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaModuloRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.ModuloResponseDTO;
import it.itsvoltapalermo.registro.facade.ModuloFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ModuloController {

    private final ModuloFacade mFacade;

    @PostMapping("/admin/modulo/aggiungi")
    public ResponseEntity<Void> aggiungiModulo(@Valid @RequestBody AggiungiModuloRequestDTO request){
        mFacade.aggiungiModulo(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/modulo/modifica")
    public ResponseEntity<Void> modificaModulo(@Valid @RequestBody ModificaModuloRequestDTO request){

        mFacade.modificaModulo(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/modulo/elimina/{id}")
    public ResponseEntity<Void> eliminaModulo(@PathVariable long id){
        mFacade.eliminaModulo(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/modulo/getModulo/{id}")
    public ResponseEntity<ModuloResponseDTO> getModulo(@PathVariable long id){
        ModuloResponseDTO mDTO = mFacade.getModulo(id);

        return ResponseEntity.ok().body(mDTO);
    }

    @GetMapping("/docente/modulo/getAll")
    public ResponseEntity<List<ModuloResponseDTO>> getAllModuli(){
        List<ModuloResponseDTO> mDTOList = mFacade.getAllModuli();

        return ResponseEntity.ok().body(mDTOList);
    }
}
