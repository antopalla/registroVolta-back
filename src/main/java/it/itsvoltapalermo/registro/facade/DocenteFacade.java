package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.DocenteResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.UsernamePasswordResponseDTO;
import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.mapper.DocenteMapper;
import it.itsvoltapalermo.registro.model.Docente;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.service.def.AuthService;
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
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    public UsernamePasswordResponseDTO aggiungiDocente(AggiungiDocenteRequestDTO request) {
        Docente d = dMapper.fromAggiungiDocenteRequestDTO(request);
        d.setRuolo(Ruolo.DOCENTE);

        String username = authService.setUsernameStd(d.getNome(),d.getCognome());
        d.setUsername(username);

        String plainPassword = authService.generaPasswordSicura();
        String hashedPassword = passwordEncoder.encode(plainPassword);
        d.setPassword(hashedPassword);

        UsernamePasswordResponseDTO dDTO = new UsernamePasswordResponseDTO();
        dDTO.setUsername(d.getUsername());
        dDTO.setPlainPassword(plainPassword);

        dService.aggiungiDocente(d);

        return dDTO;
    }

    public void modificaDocente(ModificaDocenteRequestDTO request, Utente u) {
        if(!(request.getId() == u.getId() || u.getRuolo() == Ruolo.ADMIN)) throw new CustomResponseStatusException(HttpStatus.UNAUTHORIZED, "docente", "Non autorizzato");
        Docente d = dService.getDocente(request.getId());
        if(!request.getNome().equals(d.getNome()) || !request.getCognome().equals(d.getCognome())){
            d.setUsername(authService.setUsernameStd(request.getNome(), request.getCognome()));
        }
        d.setNome(request.getNome());
        d.setCognome(request.getCognome());
        d.setDataNascita(request.getDataNascita());
        d.setCodiceFiscale(request.getCodiceFiscale());

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
