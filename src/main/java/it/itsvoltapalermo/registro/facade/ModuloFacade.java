package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiModuloRequestDTO;
import it.itsvoltapalermo.registro.dto.request.didattica.ModificaModuloRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.ModuloResponseDTO;
import it.itsvoltapalermo.registro.mapper.ModuloMapper;
import it.itsvoltapalermo.registro.model.Modulo;
import it.itsvoltapalermo.registro.service.def.CorsoService;
import it.itsvoltapalermo.registro.service.def.DocenteService;
import it.itsvoltapalermo.registro.service.def.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModuloFacade {

    private final ModuloService mService;
    private final ModuloMapper mMapper;
    private final CorsoService cService;
    private final DocenteService dService;

    public void aggiungiModulo(AggiungiModuloRequestDTO request) {
        Modulo m = mMapper.fromAggiungiModuloRequestDTO(request);
        m.setCorso(cService.getCorso(request.getIdCorso()));
        m.setDocente(dService.getDocente(request.getIdDocente()));

        mService.aggiungiModulo(m);
    }

    public void modificaModulo(ModificaModuloRequestDTO request){
        Modulo m = mService.getModulo(request.getId());
        m.setCorso(cService.getCorso(request.getIdCorso()));
        m.setDocente(dService.getDocente(request.getIdDocente()));

        mService.modificaModulo(m);
    }

    public void eliminaModulo(long id) {
        mService.eliminaModulo(id);
    }

    public ModuloResponseDTO getModulo(long id) {
        return mMapper.toModuloResponseDTO(mService.getModulo(id));
    }

    public List<ModuloResponseDTO> getAllModuli() {
        return mMapper.toModuloResponseDTOList(mService.getModuli());
    }

    public List<ModuloResponseDTO> getAllModuliByCorso(long idCorso) {
        return mMapper.toModuloResponseDTOList(mService.getModuliByCorso(idCorso));
    }
}
