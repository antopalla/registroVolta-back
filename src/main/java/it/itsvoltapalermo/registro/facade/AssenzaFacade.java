package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiAssenzaRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaAssenzaRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.AssenzaResponseDTO;
import it.itsvoltapalermo.registro.mapper.AssenzaMapper;
import it.itsvoltapalermo.registro.model.Assenza;
import it.itsvoltapalermo.registro.service.def.AssenzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AssenzaFacade {

    private final AssenzaService aService;
    private final AssenzaMapper aMapper;

    public void aggiungiAssenza(AggiungiAssenzaRequestDTO request) {
        Assenza a = aMapper.fromAggiungiAssenzaRequestDTO(request);
        aService.aggiungiAssenza(a);
    }

    public void modificaAssenza(ModificaAssenzaRequestDTO request) {
        Assenza a = aService.getAssenza(request.getId());
        aService.modificaAssenza(a);
    }

    public void eliminaAssenza(long id) {
        aService.eliminaAssenza(id);
    }

    public AssenzaResponseDTO getAssenza(long id) {
        return aMapper.toAssenzaResponseDTO(aService.getAssenza(id));
    }

    public List<AssenzaResponseDTO> getAssenze(long tutorId) {
        return aMapper.toAssenzaResponseDTOList(aService.getAssenze());
    }
}
