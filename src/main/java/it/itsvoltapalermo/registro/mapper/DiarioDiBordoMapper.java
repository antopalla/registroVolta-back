package it.itsvoltapalermo.registro.mapper;


import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiDiarioRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.DiarioResponseDTO;
import it.itsvoltapalermo.registro.model.DiarioDiBordo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiarioDiBordoMapper {


    public DiarioDiBordo fromAggiungiDiarioDiBordoDTO(AggiungiDiarioRequestDTO request) {
        DiarioDiBordo d = new DiarioDiBordo();
        d.setAziendaOspitante(request.getAziendaOspitante());
        d.setInizioTirocinio(request.getInizioTirocinio());
        d.setFineTirocinio(request.getFineTirocinio());
        d.setTutorAziendale(request.getTutorAziendale());
        return d;
    }
    public DiarioResponseDTO toDiarioResponseDTO(DiarioDiBordo d) {
        DiarioResponseDTO dDTO = new DiarioResponseDTO();
        dDTO.setId(d.getId());
        dDTO.setAziendaOspitante(d.getAziendaOspitante());
        dDTO.setInizioTirocinio(d.getInizioTirocinio());
        dDTO.setTutorAziendale(d.getTutorAziendale());
        dDTO.setFineTirocinio(d.getFineTirocinio());
        return dDTO;
    }
    public List<DiarioResponseDTO> toDiarioResponseDTOList(List<DiarioDiBordo> diari){
        List<DiarioResponseDTO> dDTOList = new ArrayList<>();
        for (DiarioDiBordo d: diari) {
            dDTOList.add(toDiarioResponseDTO(d));
        }
        return dDTOList;
    }
}
