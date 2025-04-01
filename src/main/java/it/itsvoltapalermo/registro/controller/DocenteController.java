package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.DocenteResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.UsernamePasswordResponseDTO;
import it.itsvoltapalermo.registro.facade.DocenteFacade;
import it.itsvoltapalermo.registro.model.Utente;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DocenteController {

    private final DocenteFacade facade;

    @PostMapping("/admin/docente/aggiungi")
    public ResponseEntity<UsernamePasswordResponseDTO> aggiungiDocente (@Valid @RequestBody AggiungiDocenteRequestDTO request) {
        UsernamePasswordResponseDTO dDTO = facade.aggiungiDocente(request);
        return ResponseEntity.ok(dDTO);
    }

    @PostMapping("/docente/docente/modifica")
    public ResponseEntity<Void> modificaDocente (@Valid @RequestBody ModificaDocenteRequestDTO request, UsernamePasswordAuthenticationToken upat) {
        Utente u = (Utente)upat.getPrincipal();
        facade.modificaDocente(request, u);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/docente/elimina/{id}")
    public ResponseEntity<Void> eliminaDocente (@PathVariable long id) {
        facade.eliminaDocente(id);
        return ResponseEntity.ok().build();
    }

    //TODO Modificare con security
    @GetMapping("/docente/docente/get/{id}")
    public ResponseEntity<DocenteResponseDTO> getDocente (@PathVariable long id) {
        DocenteResponseDTO tDTO = facade.getDocente(id);
        return ResponseEntity.ok(tDTO);
    }

    @GetMapping("/admin/docente/getAll")
    public ResponseEntity<List<DocenteResponseDTO>> getAllDocente () {
        List<DocenteResponseDTO> tDTO = facade.getDocenti();
        return ResponseEntity.ok(tDTO);
    }

    @PostMapping(value = "/docente/docente/aggiungiFirma", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> aggiungiFirma(@RequestParam("firma") MultipartFile firma, UsernamePasswordAuthenticationToken upat) {
        Utente u = (Utente)upat.getPrincipal();
        facade.aggiungiFirma(firma, u);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/docente/downloadFirma")
    public ResponseEntity<ByteArrayResource> downloadFirma(UsernamePasswordAuthenticationToken upat) {
        Utente u = (Utente)upat.getPrincipal();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=firma.png")
                .contentType(MediaType.IMAGE_PNG)
                .body(facade.downloadFirma(u));
    }
}
