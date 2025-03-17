package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.AggiungiStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.StudenteResponseDTO;
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

        return s;
    }

    public StudenteResponseDTO toStudenteResponseDTO(Studente s) {

        StudenteResponseDTO sDTO = new StudenteResponseDTO();
        sDTO.setId(s.getId());
        sDTO.setNome(s.getNome());
        sDTO.setCognome(s.getCognome());

        return sDTO;
    }

    public List<StudenteResponseDTO> toStudenteResponseListDTO(List<Studente> studenti) {
        List<StudenteResponseDTO> studentiListDTO = new ArrayList<>();
        for(Studente s: studenti) {
            studentiListDTO.add(toStudenteResponseDTO(s));
        }
        return studentiListDTO;
    }

}
