package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.DocenteResponseDTO;
import it.itsvoltapalermo.registro.mapper.DocenteMapper;
import it.itsvoltapalermo.registro.model.Docente;
import it.itsvoltapalermo.registro.service.def.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DocenteFacade {

    private final DocenteService dService;
    private final DocenteMapper dMapper;

    public void aggungiDocente(AggiungiDocenteRequestDTO request) {
        Docente d = dMapper.fromAggiungiDocenteRequestDTO(request);
        dService.aggiungiDocente(d);
    }

    public void modificaDocente(ModificaDocenteRequestDTO request) {
        Docente d = dService.getDocente(request.getId());
        dService.modificaDocente(d);
    }

    public void eliminaDocente(long id) {
        dService.eliminaDocente(id);
    }

    public DocenteResponseDTO getDocente(long id) {
        return dMapper.toDocenteResponseDTO(dService.getDocente(id));
    }

    public List<DocenteResponseDTO> getDocenti() {
        return dMapper.toDocenteResponseDTOList(dService.getDocenti());
    }
}
