package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiAssenzaRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.AssenzaResponseDTO;
import it.itsvoltapalermo.registro.model.Assenza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AssenzaMapper {

    public Assenza fromAggiungiAssenzaRequestDTO(AggiungiAssenzaRequestDTO aDTO){
        Assenza a = new Assenza();
        a.setDurata(aDTO.getDurata());
        return a;
    }

    public AssenzaResponseDTO toAssenzaResponseDTO(Assenza a){
        AssenzaResponseDTO aDto = new AssenzaResponseDTO();
        aDto.setId(a.getId());
        aDto.setDurata(a.getDurata());
        aDto.setIdStudente(a.getStudente().getId());
        aDto.setIdLezione(a.getLezione().getId());

        return aDto;
    }

    public List<AssenzaResponseDTO> toAssenzaResponseDTOList(List<Assenza> assenze){
        List<AssenzaResponseDTO> aDTOList = new ArrayList<>();
        for(Assenza a: assenze){
            aDTOList.add(toAssenzaResponseDTO(a));
        }
        return aDTOList;
    }
 }
