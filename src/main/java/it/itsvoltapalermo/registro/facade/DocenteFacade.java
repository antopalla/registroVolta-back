package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.DocenteResponseDTO;
import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.mapper.DocenteMapper;
import it.itsvoltapalermo.registro.model.Docente;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.service.def.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DocenteFacade {

    private final DocenteService dService;
    private final DocenteMapper dMapper;
    private final PasswordEncoder passwordEncoder;

    public void aggiungiDocente(AggiungiDocenteRequestDTO request) {
        Docente d = dMapper.fromAggiungiDocenteRequestDTO(request);
        d.setRuolo(Ruolo.DOCENTE);
        d.setPassword(passwordEncoder.encode(request.getPassword()));

        dService.aggiungiDocente(d);
    }

    public void aggiungiAdmin(AggiungiDocenteRequestDTO request) {
        Docente d = dMapper.fromAggiungiDocenteRequestDTO(request);
        d.setRuolo(Ruolo.ADMIN);
        d.setPassword(passwordEncoder.encode(request.getPassword()));

        dService.aggiungiDocente(d);
    }

    public void modificaDocente(ModificaDocenteRequestDTO request) {
        Docente d = dService.getDocente(request.getId());
        d.setNome(request.getNome());
        d.setCognome(request.getCognome());
        d.setUsername(request.getUsername());
        d.setDataNascita(request.getDataNascita());
        dService.modificaDocente(d);
    }

    public void eliminaDocente(long id) {
        dService.eliminaDocente(id);
    }

    public DocenteResponseDTO getDocente(long id) {
        return dMapper.toDocenteResponseDTO(dService.getDocente(id));
    }

    public List<DocenteResponseDTO> getDocenti() {
        return dMapper.toDocenteResponseDTOList(dService.getDocenti());
    }

    public void aggiungiFirma(MultipartFile file, Utente u) {
        if (u.getRuolo() != Ruolo.DOCENTE) throw new CustomResponseStatusException(HttpStatus.FORBIDDEN, "docente", "Non hai i permessi per eseguire questa operazione");
        if (!"image/png".equalsIgnoreCase(file.getContentType())) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "firma", "Il file caricato non è un'immagine PNG");

        Docente d = dService.getDocente(u.getId());

        try {
            d.setImmagineFirma(file.getBytes());
        } catch (Exception e) {
            throw new CustomResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "firma", "Errore durante il caricamento dell'immagine");
        }

        dService.modificaDocente(d);
    }

    public ByteArrayResource downloadFirma(Utente u){
        if (u.getRuolo() != Ruolo.DOCENTE) throw new CustomResponseStatusException(HttpStatus.FORBIDDEN, "docente", "Non hai i permessi per eseguire questa operazione");

        Docente d = dService.getDocente(u.getId());

        byte[] firma = d.getImmagineFirma();
        return new ByteArrayResource(firma);
    }
}
