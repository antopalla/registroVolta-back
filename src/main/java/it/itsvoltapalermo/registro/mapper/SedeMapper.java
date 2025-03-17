package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.governance.AggiungiSedeRequestDTO;
import it.itsvoltapalermo.registro.dto.response.governance.SedeResponseDTO;
import it.itsvoltapalermo.registro.model.Sede;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SedeMapper {

    public Sede fromAggiungiSedeRequestDTO(AggiungiSedeRequestDTO sDTO){

        Sede s = new Sede();

        s.setNome(sDTO.getNome());
        s.setIndirizzo(sDTO.getIndirizzo());
        s.setCitta(sDTO.getCitta());
        s.setCap(sDTO.getCap());

        return s;
    }

    public SedeResponseDTO toSedeResponseDTO(Sede s){
        SedeResponseDTO sDto = new SedeResponseDTO();
        sDto.setId(s.getId());
        sDto.setNome(s.getNome());
        sDto.setIndirizzo(s.getIndirizzo());
        sDto.setCitta(s.getCitta());
        sDto.setCap(s.getCap());

        return sDto;
    }

    public List<SedeResponseDTO> toSedeReponseDTOList(List<Sede> sedi){
        List<SedeResponseDTO> sedeListDTO = new ArrayList<>();
        for (Sede s : sedi) {
            sedeListDTO.add(toSedeResponseDTO(s));
        }
        return sedeListDTO;
    }
}
