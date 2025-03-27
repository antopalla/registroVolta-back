package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.DocenteResponseDTO;
import it.itsvoltapalermo.registro.model.Docente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocenteMapper {

    public Docente fromAggiungiDocenteRequestDTO(AggiungiDocenteRequestDTO dDTO){
        Docente d = new Docente();
        d.setNome(dDTO.getNome());
        d.setCognome(dDTO.getCognome());
        d.setDataNascita(dDTO.getDataNascita());
        d.setCodiceFiscale(dDTO.getCodiceFiscale());

        return d;
    }

    public DocenteResponseDTO toDocenteResponseDTO(Docente d){
        DocenteResponseDTO dDTO = new DocenteResponseDTO();
        dDTO.setId(d.getId());
        dDTO.setNome(d.getNome());
        dDTO.setCognome(d.getCognome());
        dDTO.setDataNascita(d.getDataNascita().toString());
        dDTO.setCodiceFiscale(d.getCodiceFiscale());


        // dDTO.setUsername(d.getUsername());
        // dDTO.setRuolo(d.getRuolo().toString());

        return dDTO;
    }

    public List<DocenteResponseDTO> toDocenteResponseDTOList(List<Docente> docenti){
        List<DocenteResponseDTO> dDTOList = new ArrayList<>();
        for(Docente d : docenti){
            dDTOList.add(toDocenteResponseDTO(d));
        }
        return dDTOList;
    }
}
