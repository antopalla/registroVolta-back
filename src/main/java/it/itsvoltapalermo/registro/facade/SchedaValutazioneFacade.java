package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiSchedaRequestDTO;
import it.itsvoltapalermo.registro.mapper.SchedaValutazioneMapper;
import it.itsvoltapalermo.registro.model.SchedaValutazione;
import it.itsvoltapalermo.registro.service.def.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SchedaValutazioneFacade {

    private final SchedaValutazioneService schedaService;
    private final SchedaValutazioneMapper schedaMapper;

    private final DocenteService docenteService;
    private final StudenteService studenteService;
    private final LayoutService layoutService;
    private final ModuloService moduloService;

    public void aggiungiSchedaValutazione (AggiungiSchedaRequestDTO sDTO) {
        SchedaValutazione s = schedaMapper.fromAggiungiSchedaRequestDTO(sDTO);
        s.setDocente(docenteService.getDocente(sDTO.getIdDocente()));
        s.setStudente(studenteService.getStudente(sDTO.getIdStudente()));
        s.setLayout(layoutService.getLayout(sDTO.getIdLayout()));
        s.setModulo(moduloService.getModulo(sDTO.getIdModulo()));

        schedaService.aggiungiSchedaValutazione(s);
    }

    public ByteArrayResource generaExcel (long id) {
        SchedaValutazione s = schedaService.getSchedaValutazione(id);
        byte[] excelFile = schedaService.generaExcel(s);

        return new ByteArrayResource(excelFile);
    }
}
