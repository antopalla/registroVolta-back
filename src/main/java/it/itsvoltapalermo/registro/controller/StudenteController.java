package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.AggiungiStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.ModificaStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.StudenteResponseDTO;
import it.itsvoltapalermo.registro.facade.StudenteFacade;
import it.itsvoltapalermo.registro.model.Studente;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StudenteController {

    private final StudenteFacade sFacade;

    @PostMapping("/admin/studente/registra")
    public ResponseEntity<Void> aggiungiStudente(@Valid @RequestBody AggiungiStudenteRequestDTO request) {

        sFacade.aggiungiStudente(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/studente/modifica")
    public ResponseEntity<Void> modificaStudente(@Valid @RequestBody ModificaStudenteRequestDTO request) {

        sFacade.modificaStudente(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/studente/elimina")
    public ResponseEntity<Void> eliminaStudente(@PathVariable long id){

        sFacade.eliminaStudente(id);

        return ResponseEntity.ok().build();
    }

}
