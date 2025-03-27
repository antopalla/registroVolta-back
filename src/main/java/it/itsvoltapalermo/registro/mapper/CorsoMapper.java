package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.governance.AggiungiCorsoRequestDTO;
import it.itsvoltapalermo.registro.dto.response.governance.CorsoResponseDTO;
import it.itsvoltapalermo.registro.model.Corso;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CorsoMapper {

    private final LezioneMapper lezioneMapper;
    private final StudenteMapper studenteMapper;

    public Corso fromAggiungiCorsoRequestDTO(AggiungiCorsoRequestDTO cDTO){
        Corso c = new Corso();
        c.setNome(cDTO.getNome());
        c.setDescrizione(cDTO.getDescrizione());

        return c;
    }

    public CorsoResponseDTO toCorsoResponseDTO(Corso c){
        CorsoResponseDTO cDto = new CorsoResponseDTO();
        cDto.setId(c.getId());
        cDto.setNome(c.getNome());
        cDto.setDescrizione(c.getDescrizione());
        cDto.setSede(c.getSede().getNome());
        cDto.setTutor(c.getTutor().getNome() + " " + c.getTutor().getCognome());

        // TODO: scegliere come gestire le liste
        //cDto.setLezioni(lezioneMapper.toLezioneResponseDTOList(c.getLezioni()));
        //cDto.setStudenti(studenteMapper.toStudenteResponseListDTO(c.getStudenti()));

        return cDto;
    }

    public List<CorsoResponseDTO> toCorsoResponseDTOList(List<Corso> corsi){
        List<CorsoResponseDTO> cDTOList = new ArrayList<>();
        for (Corso c: corsi){
            cDTOList.add(toCorsoResponseDTO(c));
        }
        return cDTOList;
    }
}
