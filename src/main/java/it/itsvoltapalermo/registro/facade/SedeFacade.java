package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.governance.AggiungiSedeRequestDTO;
import it.itsvoltapalermo.registro.dto.request.governance.ModificaSedeRequestDTO;
import it.itsvoltapalermo.registro.dto.response.governance.SedeResponseDTO;
import it.itsvoltapalermo.registro.mapper.SedeMapper;
import it.itsvoltapalermo.registro.model.Sede;
import it.itsvoltapalermo.registro.service.def.SedeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SedeFacade {

    private final SedeService sService;
    private final SedeMapper sMapper;

    public void aggiungiSede(AggiungiSedeRequestDTO request){
        Sede s = sMapper.fromAggiungiSedeRequestDTO(request);
        sService.aggiungiSede(s);
    }

    public void modificaSede(ModificaSedeRequestDTO request){
        Sede s = sService.getSede(request.getId());
        s.setIndirizzo(request.getIndirizzo());
        s.setCitta(request.getCitta());
        s.setCap(request.getCap());

        sService.modificaSede(s);
    }

    public void eliminaSede(long id) {
        sService.eliminaSede(id);
    }

    public SedeResponseDTO getSede(long id) {
        return sMapper.toSedeResponseDTO(sService.getSede(id));
    }

    public List<SedeResponseDTO> getAllSedi() {
        return sMapper.toSedeReponseDTOList(sService.getSedi());
    }

}
