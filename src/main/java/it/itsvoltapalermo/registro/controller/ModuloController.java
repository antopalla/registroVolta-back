package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiModuloRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaModuloRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.ModuloResponseDTO;
import it.itsvoltapalermo.registro.facade.ModuloFacade;
import it.itsvoltapalermo.registro.model.Utente;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ModuloController {

    private final ModuloFacade facade;

    @PostMapping("/admin/modulo/aggiungi")
    public ResponseEntity<Void> aggiungiModulo(@Valid @RequestBody AggiungiModuloRequestDTO request){
        facade.aggiungiModulo(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/modulo/modifica")
    public ResponseEntity<Void> modificaModulo(@Valid @RequestBody ModificaModuloRequestDTO request){
        facade.modificaModulo(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/modulo/elimina/{id}")
    public ResponseEntity<Void> eliminaModulo(@PathVariable long id){
        facade.eliminaModulo(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/modulo/getModulo/{id}")
    public ResponseEntity<ModuloResponseDTO> getModulo(@PathVariable long id){
        ModuloResponseDTO mDTO = facade.getModulo(id);
        return ResponseEntity.ok().body(mDTO);
    }

    @GetMapping("/docente/modulo/getAll")
    public ResponseEntity<List<ModuloResponseDTO>> getAllModuli(){
        List<ModuloResponseDTO> mDTOList = facade.getAllModuli();
        return ResponseEntity.ok().body(mDTOList);
    }

    @GetMapping("/docente/modulo/getAllByDocente")
    public ResponseEntity<List<ModuloResponseDTO>> getAllModuliByDocente(UsernamePasswordAuthenticationToken upat){
        Utente u = (Utente)upat.getPrincipal();
        List<ModuloResponseDTO> mDTOList = facade.getAllModuliByDocente(u.getId());
        return ResponseEntity.ok().body(mDTOList);
    }

    @GetMapping("/docente/modulo/getAllByCorso/{idCorso}")
    public ResponseEntity<List<ModuloResponseDTO>> getAllModuliByCorso(@PathVariable long idCorso){
        List<ModuloResponseDTO> mDTOList = facade.getAllModuliByCorso(idCorso);
        return ResponseEntity.ok().body(mDTOList);
    }

}
