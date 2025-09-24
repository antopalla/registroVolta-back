package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.StudenteAssenzeResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.StudenteResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.UsernamePasswordResponseDTO;
import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.mapper.AssenzaMapper;
import it.itsvoltapalermo.registro.mapper.StudenteMapper;
import it.itsvoltapalermo.registro.model.Assenza;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Studente;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.service.def.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudenteFacade {

    private final StudenteMapper sMapper;
    private final StudenteService sService;
    private final CorsoService cService;
    private final AssenzaService aService;
    private final DiarioDiBordoService dService;
    private final AssenzaMapper aMapper;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    public UsernamePasswordResponseDTO aggiungiStudente(AggiungiStudenteRequestDTO request){
        Studente s = sMapper.fromAggiungiStudenteRequestDTO(request);
        if(request.getIdDiario() != 0) s.setDiarioDiBordo(dService.getDiario(request.getIdDiario()));
        s.setCorso(cService.getCorso(request.getIdCorso()));
        s.setRuolo(Ruolo.STUDENTE);

        String username = authService.setUsernameStd(s.getNome(), s.getCognome());
        s.setUsername(username);

        String plainPassword = authService.generaPasswordSicura();
        String hashedPassword = passwordEncoder.encode(plainPassword);
        s.setPassword(hashedPassword);

        UsernamePasswordResponseDTO sDTO = new UsernamePasswordResponseDTO();
        sDTO.setUsername(username);
        sDTO.setPlainPassword(plainPassword);

        sService.aggiungiStudente(s);

        return sDTO;
    }


    public void modificaStudente(ModificaStudenteRequestDTO request, Utente u){
        if(!(request.getId() == u.getId() || u.getRuolo() == Ruolo.ADMIN)) throw new CustomResponseStatusException(HttpStatus.UNAUTHORIZED, "studente", "Non autorizzato");

        Studente s = sService.getStudente(request.getId());

        if(!request.getNome().equals(s.getNome()) || !request.getCognome().equals(s.getCognome())){
            s.setUsername(authService.setUsernameStd(request.getNome(), request.getCognome()));
        }
            s.setNome(request.getNome());
            s.setCognome(request.getCognome());
            s.setCorso(cService.getCorso(request.getIdCorso()));
            if (request.getIdDiario() != 0) s.setDiarioDiBordo(dService.getDiario(request.getIdDiario()));
            s.setCodiceFiscale(request.getCodiceFiscale());
            s.setDataNascita(request.getDataNascita());


        sService.modificaStudente(s);
    }

    public void eliminaStudente(Long idStudente){
        sService.eliminaStudente(idStudente);
    }

    public StudenteResponseDTO getStudente(long id, Utente u){
        if(!(u.getId() == id || u.getRuolo() == Ruolo.ADMIN || u.getRuolo() == Ruolo.DOCENTE || u.getRuolo() == Ruolo.TUTOR )) throw new CustomResponseStatusException(HttpStatus.UNAUTHORIZED, "studente", "Non autorizzato");
        return sMapper.toStudenteResponseDTO(sService.getStudente(id));
    }

    public List<StudenteResponseDTO> getAllStudenti(){
        return sMapper.toStudenteResponseListDTO(sService.getStudenti());
    }

    public List<StudenteResponseDTO> getStudentiByCorso(long id){
        return sMapper.toStudenteResponseListDTO(sService.getStudentiByCorso(id));
    }

    public List<StudenteAssenzeResponseDTO> getStudentiByOreAssenza(int oreAssenza) {
        List<Studente> studenti = sService.getStudentiByOreAssenza(oreAssenza);
        List<StudenteAssenzeResponseDTO> studentiAssenze = new ArrayList<>();

        for(Studente s: studenti) {
            StudenteAssenzeResponseDTO sDTO = new StudenteAssenzeResponseDTO();
            sDTO.setId(s.getId());
            sDTO.setNome(s.getNome());
            sDTO.setCognome(s.getCognome());
            sDTO.setTotaleOreAssenza(s.getAssenze().stream().mapToDouble(Assenza::getDurata).sum());
            sDTO.setAssenze(aMapper.toAssenzaResponseDTOList(aService.getAssenzeByStudente(s.getId())));
            studentiAssenze.add(sDTO);
        }

        return studentiAssenze;
    }
}
