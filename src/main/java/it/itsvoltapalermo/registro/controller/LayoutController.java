package it.itsvoltapalermo.registro.controller;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiLayoutRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaLayoutRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.LayoutResponseDTO;
import it.itsvoltapalermo.registro.facade.LayoutFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LayoutController {
    private final LayoutFacade lFacade;

    @PostMapping(value = "/admin/layout/aggiungi", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> aggiungiLayout(@Valid @ModelAttribute AggiungiLayoutRequestDTO request){
        lFacade.aggiungiLayout(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/layout/modifica")
    public ResponseEntity<Void> modificaLayout(@Valid @RequestBody ModificaLayoutRequestDTO request){
        facade.modificaLayout(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/layout/elimina/{id}")
    public ResponseEntity<Void> eliminaLayout(@PathVariable long id){
        facade.eliminaLayout(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/layout/getLayout/{id}")
    public ResponseEntity<LayoutResponseDTO> getLayout(@PathVariable long id){
        LayoutResponseDTO lDTO = facade.getLayout(id);
        return ResponseEntity.ok().body(lDTO);
    }

    @GetMapping("/docente/layout/getAll")
    public ResponseEntity<List<LayoutResponseDTO>> getAllLayouts(){
        List<LayoutResponseDTO> lDTOList = facade.getLayouts();
        return ResponseEntity.ok().body(lDTOList);
    }

    @GetMapping("/docente/layout/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadLayout(@PathVariable long id) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=layout.xlsx")
                    .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .body(lFacade.downloadLayout(id));
    }
}
