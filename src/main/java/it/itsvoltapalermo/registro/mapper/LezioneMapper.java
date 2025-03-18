package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiLezioneRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.LezioneResponseDTO;
import it.itsvoltapalermo.registro.model.Lezione;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LezioneMapper {

    public Lezione fromAggiungiLezioneRequestDTO(AggiungiLezioneRequestDTO lDTO) {
        Lezione l = new Lezione();
        l.setDescrizione(lDTO.getDescrizione());
        l.setData(lDTO.getData());
        l.setOraInizio(lDTO.getOraInizio());
        l.setOraFine(lDTO.getOraFine());

        return l;
    }

    public LezioneResponseDTO toLezioneResponseDTO (Lezione l) {
        LezioneResponseDTO lDTO = new LezioneResponseDTO();
        lDTO.setId(l.getId());
        lDTO.setDescrizione(l.getDescrizione());
        lDTO.setData(l.getData());
        lDTO.setOraInizio(l.getOraInizio());
        lDTO.setOraFine(l.getOraFine());
        return lDTO;
    }

    public List<LezioneResponseDTO> toLezioneResponseDTOList (List<Lezione> lezioni){
        List<LezioneResponseDTO> lDTOList = new ArrayList<>();
        for (Lezione l : lezioni){
            lDTOList.add(toLezioneResponseDTO(l));
        }
        return lDTOList;
    }
}
