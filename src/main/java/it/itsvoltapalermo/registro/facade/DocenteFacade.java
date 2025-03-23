package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaDocenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.DocenteResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.UsernamePasswordResponseDTO;
import it.itsvoltapalermo.registro.mapper.DocenteMapper;
import it.itsvoltapalermo.registro.model.Docente;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.service.def.AuthService;
import it.itsvoltapalermo.registro.service.def.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DocenteFacade {

    private final DocenteService dService;
    private final DocenteMapper dMapper;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    public UsernamePasswordResponseDTO aggiungiDocente(AggiungiDocenteRequestDTO request) {
        Docente d = dMapper.fromAggiungiDocenteRequestDTO(request);
        d.setRuolo(Ruolo.DOCENTE);

        String username = authService.setUsernameStd(d.getNome(),d.getCognome());
        d.setUsername(username);

        String plainPassword = authService.generaPasswordSicura();
        String hashedPassword = passwordEncoder.encode(plainPassword);
        d.setPassword(hashedPassword);

        UsernamePasswordResponseDTO dDTO = new UsernamePasswordResponseDTO();
        dDTO.setUsername(d.getUsername());
        dDTO.setPlainPassword(plainPassword);

        dService.aggiungiDocente(d);

        return dDTO;
    }

    public void modificaDocente(ModificaDocenteRequestDTO request) {
        Docente d = dService.getDocente(request.getId());
        if(!request.getNome().equals(d.getNome()) || !request.getCognome().equals(d.getCognome())){
            d.setUsername(authService.setUsernameStd(request.getNome(), request.getCognome()));
        }
        d.setNome(request.getNome());
        d.setCognome(request.getCognome());
        d.setDataNascita(request.getDataNascita());
        d.setCodiceFiscale(request.getCodiceFiscale());

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
