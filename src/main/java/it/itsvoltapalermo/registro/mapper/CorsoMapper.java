package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.governance.AggiungiCorsoRequestDTO;
import it.itsvoltapalermo.registro.dto.response.governance.CorsoResponseDTO;
import it.itsvoltapalermo.registro.model.Corso;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CorsoMapper {

    public Corso fromAggiungiCorsoRequestDTO(AggiungiCorsoRequestDTO cDTO){

        Corso c = new Corso();

        c.setNome(cDTO.getNome());
        c.setDescrizione(cDTO.getDescrizione());

        return c;
    }

    public CorsoResponseDTO toCorsoResponseDTO(Corso c){

        CorsoResponseDTO cDto = new CorsoResponseDTO();

        cDto.setNome(c.getNome());
        cDto.setDescrizione(c.getDescrizione());

        return cDto;
    }

    public List<CorsoResponseDTO> toCorsoResponseDTOList(List<Corso> corsi){
        List<CorsoResponseDTO> corsoListDto = new ArrayList<>();

        for (Corso c: corsi){
            corsoListDto.add(toCorsoResponseDTO(c));
        }
        return corsoListDto;
    }
}
