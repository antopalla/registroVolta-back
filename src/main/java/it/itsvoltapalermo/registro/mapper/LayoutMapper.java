package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiLayoutRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.LayoutResponseDTO;
import it.itsvoltapalermo.registro.model.Layout;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LayoutMapper {

    public Layout fromAggiungiLayoutRequestDTO(AggiungiLayoutRequestDTO lDTO){
        Layout l = new Layout();
        l.setNome(lDTO.getNome());
        l.setDescrizione(lDTO.getDescrizione());

        return l;
    }

    public LayoutResponseDTO toLayoutResponseDTO(Layout l){
        LayoutResponseDTO lDTO = new LayoutResponseDTO();
        lDTO.setId(l.getId());
        lDTO.setNome(l.getNome());
        lDTO.setDescrizione(l.getDescrizione());
        lDTO.setDataCreazione(l.getDataCreazione().toString());
        lDTO.setPath(l.getPath());

        return lDTO;
    }

    public List<LayoutResponseDTO> toLayoutResponseDTOList(List<Layout> layouts){
        List<LayoutResponseDTO> lDTOList = new ArrayList<>();
        for(Layout l : layouts){
            lDTOList.add(toLayoutResponseDTO(l));
        }
        return lDTOList;
    }
}
