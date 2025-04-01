package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiPaginaRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaPaginaRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.PaginaResponseDTO;
import it.itsvoltapalermo.registro.facade.PaginaFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PaginaController {

    private final PaginaFacade facade;

    @PostMapping("/studente/pagina/aggiungi")
    public ResponseEntity<Void> aggiungiPagina(@RequestBody @Valid AggiungiPaginaRequestDTO request) {
        facade.aggiungiPagina(request);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/studente/pagina/modifica")
    public ResponseEntity<Void> modificaPagina(@RequestBody @Valid ModificaPaginaRequestDTO request) {
        facade.modificaPagina(request);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/admin/pagina/elimina")
    public ResponseEntity<Void> eliminaPagina(@PathVariable long id){
        facade.eliminaPagina(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/admin/pagina/getPagina/{id}")
    public ResponseEntity<PaginaResponseDTO> getPagina(@PathVariable long id){
        PaginaResponseDTO dto = facade.getPagina(id);
        return ResponseEntity.ok(dto);
    }
    //TODO finire controller
    /*

    @GetMapping("/admin/pagina/getPagine")
    public ResponseEntity<List<PaginaResponseDTO>> getAllPagine(){
        List<PaginaResponseDTO> dtoList = facade.getPagine();
        return ResponseEntity.ok(dtoList);
    }

     */
}
