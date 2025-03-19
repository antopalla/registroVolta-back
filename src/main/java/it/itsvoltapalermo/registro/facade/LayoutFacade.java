package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiLayoutRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaLayoutRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.LayoutResponseDTO;
import it.itsvoltapalermo.registro.mapper.LayoutMapper;
import it.itsvoltapalermo.registro.model.Layout;
import it.itsvoltapalermo.registro.service.def.LayoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LayoutFacade {

    private final LayoutService lService;
    private final LayoutMapper lMapper;

    public void aggiungiLayout(AggiungiLayoutRequestDTO request){
        Layout l = lMapper.fromAggiungiLayoutRequestDTO(request);
        l.setDataCreazione(LocalDateTime.now());
        lService.aggiungiLayout(l);
    }

    public void modificaLayout(ModificaLayoutRequestDTO request){
        Layout l = lService.getLayout(request.getId());
        l.setNome(request.getNome());
        l.setDescrizione(request.getDescrizione());
        l.setPath(request.getPath());

        lService.modificaLayout(l);
    }

    public void eliminaLayout(long id){
        lService.eliminaLayout(id);
    }

    public LayoutResponseDTO getLayout(long id){
        return lMapper.toLayoutResponseDTO(lService.getLayout(id));
    }

    public List<LayoutResponseDTO> getLayouts(){
        return lMapper.toLayoutResponseDTOList(lService.getLayouts());
    }
}
