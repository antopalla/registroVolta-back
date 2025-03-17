package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.governance.AggiungiCorsoRequestDTO;
import it.itsvoltapalermo.registro.dto.request.governance.ModificaCorsoRequestDTO;
import it.itsvoltapalermo.registro.dto.response.governance.CorsoResponseDTO;
import it.itsvoltapalermo.registro.mapper.CorsoMapper;
import it.itsvoltapalermo.registro.model.Corso;
import it.itsvoltapalermo.registro.service.def.CorsoService;
import it.itsvoltapalermo.registro.service.def.SedeService;
import it.itsvoltapalermo.registro.service.def.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CorsoFacade {

    private final CorsoService cService;
    private final TutorService tService;
    private final SedeService sService;
    private final CorsoMapper cMapper;

    public void aggiungiCorso(AggiungiCorsoRequestDTO request) {
        Corso c = cMapper.fromAggiungiCorsoRequestDTO(request);
        c.setTutor(tService.getTutor(request.getIdTutor()));
        c.setSede(sService.getSede(request.getIdSede()));

        cService.aggiungiCorso(c);
    }

    public void modificaCorso(ModificaCorsoRequestDTO request) {
        Corso c = cService.getCorso(request.getId());
        c.setSede(sService.getSede(request.getIdSede()));
        c.setTutor(tService.getTutor(request.getIdTutor()));
        c.setNome(request.getNome());
        c.setDescrizione(request.getDescrizione());

        cService.modificaCorso(c);
    }

    public void eliminaCorso(long id) {cService.eliminaCorso(id);}

    public CorsoResponseDTO getCorso(long id) {

        return cMapper.toCorsoResponseDTO(cService.getCorso(id));
    }
    public List<CorsoResponseDTO> getCorsi() {
        return cMapper.toCorsoResponseDTOList(cService.getCorsi());
    }

}
