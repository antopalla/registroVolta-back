package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiPaginaRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.PaginaResponseDTO;
import it.itsvoltapalermo.registro.model.Pagina;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaginaMapper {


    public Pagina fromAggiungiPaginaRequestDTO(AggiungiPaginaRequestDTO request) {
        Pagina p = new Pagina();
        p.setInizioSettimana(request.getInizioSettimana());
        p.setFineSettimana(request.getFineSettimana());
        p.setAttivitaSvolte(request.getAttivitaSvolte());
        p.setCompetenzeAcquisite(request.getCompetenzeAcquisite());
        p.setDataCompilazione(request.getDataCompilazione());
        p.setDifficoltaIncontrate(request.getDifficoltaIncontrate());
        p.setRiflessioniPersonali(request.getRiflessioniPersonali());
        p.setStrumentiUtilizzati(request.getStrumentiUtilizzati());
        p.setRiferimentiDiscipline(request.getRiferimentiDiscipline());
        p.setObiettiviSettimanali(request.getObiettiviSettimanali());

        return p;
    }
    public PaginaResponseDTO toPaginaResponseDTO(Pagina p) {
        PaginaResponseDTO dto = new PaginaResponseDTO();
        dto.setInizioSettimana(p.getInizioSettimana());
        dto.setFineSettimana(p.getFineSettimana());
        dto.setAttivitaSvolte(p.getAttivitaSvolte());
        dto.setDataCompilazione(p.getDataCompilazione());
        dto.setDifficoltaIncontrate(p.getDifficoltaIncontrate());
        dto.setRiflessioniPersonali(p.getRiflessioniPersonali());
        dto.setStrumentiUtilizzati(p.getStrumentiUtilizzati());
        dto.setObiettiviSettimanali(p.getObiettiviSettimanali());
        dto.setCompetenzeAcquisite(p.getCompetenzeAcquisite());
        dto.setRiflessioniPersonali(p.getRiflessioniPersonali());
        return dto;
    }

    public List<PaginaResponseDTO> toPaginaResponseDTOList(List<Pagina> pagine){
        List<PaginaResponseDTO> pDTOList = new ArrayList<>();
        for (Pagina p: pagine) {
            pDTOList.add(toPaginaResponseDTO(p));
        }
        return pDTOList;
    }
}
