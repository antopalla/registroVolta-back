package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiDiarioRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaDiarioRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.DiarioResponseDTO;
import it.itsvoltapalermo.registro.mapper.DiarioDiBordoMapper;
import it.itsvoltapalermo.registro.mapper.DocenteMapper;
import it.itsvoltapalermo.registro.model.DiarioDiBordo;
import it.itsvoltapalermo.registro.service.def.DiarioDiBordoService;
import it.itsvoltapalermo.registro.service.def.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiarioDiBordoFacade {

    private final DiarioDiBordoService dService;
    private final DiarioDiBordoMapper dMapper;

    public void aggiungiDiario(AggiungiDiarioRequestDTO dDTO){
        DiarioDiBordo d = dMapper.fromAggiungiDiarioDiBordoDTO(dDTO);
        dService.aggiungiDiario(d);
    }

    public void modificaDiario(ModificaDiarioRequestDTO dDTO){
        DiarioDiBordo d = dService.getDiario(dDTO.getId());
        d.setId(dDTO.getId());
        d.setAziendaOspitante(dDTO.getAziendaOspitante());
        d.setTutorAziendale(dDTO.getTutorAziendale());
        d.setInizioTirocinio(dDTO.getInizioTirocinio());
        d.setFineTirocinio(dDTO.getFineTirocinio());
        dService.modificaDiario(d);
    }

    public void eliminaDiario(long id){
        dService.eliminaDiario(id);
    }

    public DiarioResponseDTO getDiario(long id){
        return dMapper.toDiarioResponseDTO(dService.getDiario(id));
    }
    //TODO da implementare
    /*
    public List<DiarioResponseDTO> getDiarioByStudente(){}
    */
}
