package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiAssenzaRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaAssenzaRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.AssenzaResponseDTO;
import it.itsvoltapalermo.registro.mapper.AssenzaMapper;
import it.itsvoltapalermo.registro.model.Assenza;
import it.itsvoltapalermo.registro.service.def.AssenzaService;
import it.itsvoltapalermo.registro.service.def.LezioneService;
import it.itsvoltapalermo.registro.service.def.StudenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AssenzaFacade {

    private final AssenzaService aService;
    private final AssenzaMapper aMapper;
    private final LezioneService lService;
    private final StudenteService sService;

    public void aggiungiAssenza(AggiungiAssenzaRequestDTO request) {
        Assenza a = aMapper.fromAggiungiAssenzaRequestDTO(request);
        a.setLezione(lService.getLezione(request.getIdLezione()));
        a.setStudente(sService.getStudente(request.getIdStudente()));

        aService.aggiungiAssenza(a);
    }

    public void modificaAssenza(ModificaAssenzaRequestDTO request) {
        Assenza a = aService.getAssenza(request.getId());
        a.setDurata(request.getDurata());

        aService.modificaAssenza(a);
    }

    public void eliminaAssenza(long id) {
        aService.eliminaAssenza(id);
    }

    public AssenzaResponseDTO getAssenza(long id) {
        return aMapper.toAssenzaResponseDTO(aService.getAssenza(id));
    }

    public List<AssenzaResponseDTO> getAssenze() {
        return aMapper.toAssenzaResponseDTOList(aService.getAssenze());
    }

    public List<AssenzaResponseDTO> getAssenzeByStudente(long idStudente) {
        return aMapper.toAssenzaResponseDTOList(aService.getAssenzeByStudente(idStudente));
    }

    public List<AssenzaResponseDTO> getAssenzeByLezione(long idLezione) {
        return aMapper.toAssenzaResponseDTOList(aService.getAssenzeByLezione(idLezione));
    }
}
