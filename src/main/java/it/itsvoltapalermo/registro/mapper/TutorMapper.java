package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiTutorRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.TutorResponseDTO;
import it.itsvoltapalermo.registro.model.Tutor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TutorMapper {
    public Tutor fromAggiungiTutorRequestDTO(AggiungiTutorRequestDTO tDTO) {
        Tutor t = new Tutor();
        t.setNome(tDTO.getNome());
        t.setCognome(tDTO.getCognome());
        t.setUsername(tDTO.getUsername());
        t.setPassword(tDTO.getPassword());
        return t;
    }

    public TutorResponseDTO toTutorReponseDTO(Tutor t) {
        TutorResponseDTO tDTO = new TutorResponseDTO();
        tDTO.setId(t.getId());
        tDTO.setNome(t.getNome());
        tDTO.setCognome(t.getCognome());
        tDTO.setUsername(t.getUsername());
        tDTO.setRuolo(t.getRuolo().toString());
        return tDTO;
    }

    public List<TutorResponseDTO> toTutorResponseDTOList(List<Tutor> tutor) {
        List<TutorResponseDTO> tutorDTO = new ArrayList<>();
        for (Tutor t : tutor) {
            tutorDTO.add(toTutorReponseDTO(t));
        }
        return tutorDTO;
    }
}
