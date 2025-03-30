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
        t.setDataNascita(tDTO.getDataNascita());
        t.setCodiceFiscale(tDTO.getCodiceFiscale());
        return t;
    }

    public TutorResponseDTO toTutorReponseDTO(Tutor t) {
        TutorResponseDTO tDTO = new TutorResponseDTO();
        tDTO.setId(t.getId());
        tDTO.setNome(t.getNome());
        tDTO.setCognome(t.getCognome());
        tDTO.setDataNascita(t.getDataNascita().toString());
        tDTO.setCodiceFiscale(t.getCodiceFiscale());

        tDTO.setUsername(t.getUsername());
        tDTO.setRuolo(t.getRuolo().toString());

        return tDTO;
    }

    public List<TutorResponseDTO> toTutorResponseDTOList(List<Tutor> tutor) {
        List<TutorResponseDTO> tDTOList = new ArrayList<>();
        for (Tutor t : tutor) {
            tDTOList.add(toTutorReponseDTO(t));
        }
        return tDTOList;
    }
}
