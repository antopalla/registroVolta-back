package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.CambiaPasswordRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.LoginRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.TutorResponseDTO;
import it.itsvoltapalermo.registro.mapper.TutorMapper;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Tutor;
import it.itsvoltapalermo.registro.service.def.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorFacade {

    private final TutorService tutorService;
    private final TutorMapper tutorMapper;

    public void aggiungiTutor(AggiungiTutorRequestDTO request) {
        Tutor t = tutorMapper.fromAggiungiTutorRequestDTO(request);
        t.setRuolo(Ruolo.TUTOR);
        tutorService.aggiungiTutor(t);
    }

    public void aggiungiAdmin(AggiungiTutorRequestDTO request) {
        Tutor t = tutorMapper.fromAggiungiTutorRequestDTO(request);
        t.setRuolo(Ruolo.ADMIN);
        tutorService.aggiungiTutor(t);
    }

    public Tutor login(LoginRequestDTO request) {
        return tutorService.login(request.getUsername(), request.getPassword());
    }

    public void cambiaPassword(CambiaPasswordRequestDTO request) {
        Tutor t = tutorService.getTutor(request.getId());

        if (t.isDisattivato()) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        if (!t.getPassword().equals(request.getVecchiaPassword())) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        if (!request.getNuovaPassword().equals(request.getNuovaPasswordRipetuta())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le password non coincidono!");

        t.setPassword(request.getNuovaPassword());
        tutorService.modificaTutor(t);
    }

    public void eliminaTutor(long id) {
        tutorService.eliminaTutor(id);
    }

    public TutorResponseDTO getTutor (long id) {
        return tutorMapper.toTutorReponseDTO(tutorService.getTutor(id));
    }

    public List<TutorResponseDTO> getAllTutor() {
        return tutorMapper.toTutorResponseDTOList(tutorService.getTutors());
    }

}
