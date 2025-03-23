package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.TutorResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.UsernamePasswordResponseDTO;
import it.itsvoltapalermo.registro.mapper.TutorMapper;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Tutor;
import it.itsvoltapalermo.registro.service.def.AuthService;
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
    private final AuthService authService;


    public UsernamePasswordResponseDTO aggiungiTutor(AggiungiTutorRequestDTO request) {
        Tutor t = tutorMapper.fromAggiungiTutorRequestDTO(request);
        t.setRuolo(Ruolo.TUTOR);

        String username = authService.setUsernameStd(t.getNome(), t.getCognome());
        t.setUsername(username);

        String plainPassword = authService.generaPasswordSicura();
        String hashedPassword = passwordEncoder.encode(plainPassword);
        t.setPassword(hashedPassword);

        UsernamePasswordResponseDTO tDTO = new UsernamePasswordResponseDTO();
        tDTO.setUsername(username);
        tDTO.setPlainPassword(plainPassword);

        tutorService.aggiungiTutor(t);

        return tDTO;
    }

    public UsernamePasswordResponseDTO aggiungiAdmin(AggiungiTutorRequestDTO request) {
        Tutor t = tutorMapper.fromAggiungiTutorRequestDTO(request);
        t.setRuolo(Ruolo.ADMIN);

        String username = authService.setUsernameStd(t.getNome(), t.getCognome());
        t.setUsername(username);

        String plainPassword = authService.generaPasswordSicura();
        String hashedPassword = passwordEncoder.encode(plainPassword);
        t.setPassword(hashedPassword);

        UsernamePasswordResponseDTO aDTO = new UsernamePasswordResponseDTO();
        aDTO.setUsername(username);
        aDTO.setPlainPassword(plainPassword);

        tutorService.aggiungiTutor(t);
        return aDTO;
    }

    public void modificaTutor(ModificaTutorRequestDTO request){
        Tutor t = tutorService.getTutor(request.getId());
        if(!request.getNome().equals(t.getNome()) || !request.getCognome().equals(t.getCognome())){
            t.setUsername(authService.setUsernameStd(request.getNome(), request.getCognome()));
        }
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
