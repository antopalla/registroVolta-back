package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.StudenteResponseDTO;
import it.itsvoltapalermo.registro.model.Studente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudenteMapper {

    public Studente fromAggiungiStudenteRequestDTO(AggiungiStudenteRequestDTO sDTO) {

        Studente s = new Studente();
        s.setNome(sDTO.getNome());
        s.setCognome(sDTO.getCognome());
        s.setUsername(sDTO.getUsername());
        s.setDataNascita(sDTO.getDataNascita());
        s.setCodiceFiscale(sDTO.getCodiceFiscale());
        return s;
    }

    public StudenteResponseDTO toStudenteResponseDTO(Studente s) {

        StudenteResponseDTO sDTO = new StudenteResponseDTO();
        sDTO.setId(s.getId());
        sDTO.setNome(s.getNome());
        sDTO.setCognome(s.getCognome());
        sDTO.setUsername(s.getUsername());
        sDTO.setDataNascita(s.getDataNascita().toString());
        sDTO.setCodiceFiscale(s.getCodiceFiscale());
        sDTO.setCorso(s.getCorso().getNome());
        sDTO.setRuolo(s.getRuolo().toString());
        return sDTO;
    }

    public List<StudenteResponseDTO> toStudenteResponseListDTO(List<Studente> studenti) {
        List<StudenteResponseDTO> sDTOList = new ArrayList<>();
        for(Studente s: studenti) {
            sDTOList.add(toStudenteResponseDTO(s));
        }
        return sDTOList;
    }

}
