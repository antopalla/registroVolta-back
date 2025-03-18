package it.itsvoltapalermo.registro.facade;


import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiLezioneRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaLezioneRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.LezioneResponseDTO;
import it.itsvoltapalermo.registro.mapper.LezioneMapper;
import it.itsvoltapalermo.registro.model.Lezione;
import it.itsvoltapalermo.registro.service.def.CorsoService;
import it.itsvoltapalermo.registro.service.def.DocenteService;
import it.itsvoltapalermo.registro.service.def.LezioneService;
import it.itsvoltapalermo.registro.service.def.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LezioneFacade {

    private final LezioneMapper lMapper;
    private final LezioneService lService;
    private final DocenteService dService;
    private final ModuloService mService;
    private final CorsoService cService;

    public void aggiungiLezione(AggiungiLezioneRequestDTO request) {
        Lezione l = lMapper.fromAggiungiLezioneRequestDTO(request);
        l.setModulo(mService.getModulo(request.getIdModulo()));
        l.setCorso(cService.getCorso(request.getIdCorso()));
        l.setDocente(dService.getDocente(request.getIdDocente()));

        lService.aggiungiLezione(l);
    }

    public void modificaLezione(ModificaLezioneRequestDTO request) {
        Lezione l = lService.getLezione(request.getId());
        l.setModulo(mService.getModulo(request.getIdModulo()));
        l.setCorso(cService.getCorso(request.getIdCorso()));
        l.setDocente(dService.getDocente(request.getIdDocente()));

        lService.modificaLezione(l);
    }

    public void eliminaLezione(long id) {
        lService.eliminaLezione(id);
    }

    public LezioneResponseDTO getLezione(long id) {
        return lMapper.toLezioneResponseDTO(lService.getLezione(id));
    }

    public List<LezioneResponseDTO> getAllLezioni() {
        return lMapper.toLezioneResponseDTOList(lService.getLezioni());
    }
}
