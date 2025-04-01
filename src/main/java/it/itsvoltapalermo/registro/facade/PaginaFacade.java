package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiPaginaRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaPaginaRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.PaginaResponseDTO;
import it.itsvoltapalermo.registro.mapper.PaginaMapper;
import it.itsvoltapalermo.registro.model.Pagina;
import it.itsvoltapalermo.registro.service.def.DiarioDiBordoService;
import it.itsvoltapalermo.registro.service.def.PaginaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PaginaFacade {

    private final PaginaService pService;
    private final DiarioDiBordoService dService;
    private final PaginaMapper pMapper;


    public void aggiungiPagina(AggiungiPaginaRequestDTO pDTO){
        Pagina p = pMapper.fromAggiungiPaginaRequestDTO(pDTO);
        p.setDiarioDiBordo(dService.getDiario(pDTO.getIdDiario()));
        pService.aggiungiPagina(p);
    }

    public void modificaPagina(ModificaPaginaRequestDTO pDTO){
        Pagina p = pService.getPagina(pDTO.getId());
        p.setDiarioDiBordo(dService.getDiario(pDTO.getIdDiario()));
        pService.modificaPagina(p);
    }

    public void eliminaPagina(long id){
        pService.eliminaPagina(id);
    }


    public PaginaResponseDTO getPagina(long id){
        return pMapper.toPaginaResponseDTO(pService.getPagina(id));
    }

    //TODO da implementare
    /*
    public List<PaginaResponseDTO> getPagina(long idDiario){
        return pMapper.toPaginaResponseDTOList(pService.getPagineByDiario(idDiario));
    }
    */
}
