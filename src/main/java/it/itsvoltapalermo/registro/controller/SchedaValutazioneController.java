package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiSchedaRequestDTO;
import it.itsvoltapalermo.registro.facade.SchedaValutazioneFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO Finire controller
@RequiredArgsConstructor
@RestController
public class SchedaValutazioneController {

    private final SchedaValutazioneFacade facade;

    @PostMapping("/docente/schedavalutazione/aggiungi")
    public ResponseEntity<Void> aggiungiScheda(@Valid  @RequestBody AggiungiSchedaRequestDTO request) {
        facade.aggiungiSchedaValutazione(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/schedavalutazione/downloadscheda/{id}")
    public ResponseEntity<ByteArrayResource> ottieniScheda(@PathVariable long id) {
        try {
            ByteArrayResource resource = facade.generaExcel(id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=scheda_di_valutazione_compilata.xlsx")
                    .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
