package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.TutorResponseDTO;
import it.itsvoltapalermo.registro.mapper.TutorMapper;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Tutor;
import it.itsvoltapalermo.registro.service.def.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorFacade {

    private final TutorService tutorService;
    private final TutorMapper tutorMapper;
    private final PasswordEncoder passwordEncoder;

    public void aggiungiTutor(AggiungiTutorRequestDTO request) {
        Tutor t = tutorMapper.fromAggiungiTutorRequestDTO(request);
        t.setRuolo(Ruolo.TUTOR);
        t.setPassword(passwordEncoder.encode(request.getPassword()));

        tutorService.aggiungiTutor(t);
    }

    public void aggiungiAdmin(AggiungiTutorRequestDTO request) {
        Tutor t = tutorMapper.fromAggiungiTutorRequestDTO(request);
        t.setRuolo(Ruolo.ADMIN);
        t.setPassword(passwordEncoder.encode(request.getPassword()));

        tutorService.aggiungiTutor(t);
    }

    public void modificaTutor(ModificaTutorRequestDTO request){
        Tutor t = tutorService.getTutor(request.getId());
        t.setUsername(request.getUsername());
        t.setNome(request.getNome());
        t.setCognome(request.getCognome());
        t.setCodiceFiscale(request.getCodiceFiscale());
        t.setDataNascita(request.getDataNascita());

        tutorService.modificaTutor(t);
    }

    public void eliminaTutor(long id) {
        tutorService.eliminaTutor(id);
    }

    public TutorResponseDTO getTutor (long id) {
        return tutorMapper.toTutorReponseDTO(tutorService.getTutor(id));
    }

    public List<TutorResponseDTO> getTutors() {
        return tutorMapper.toTutorResponseDTOList(tutorService.getTutors());
    }

}
