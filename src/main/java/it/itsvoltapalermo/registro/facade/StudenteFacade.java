package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.AggiungiStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.ModificaStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.StudenteResponseDTO;
import it.itsvoltapalermo.registro.mapper.StudenteMapper;
import it.itsvoltapalermo.registro.model.Studente;
import it.itsvoltapalermo.registro.service.def.CorsoService;
import it.itsvoltapalermo.registro.service.def.StudenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudenteFacade {

    private final StudenteMapper sMapper;
    private final StudenteService sService;
    private final CorsoService cService;

    public void aggiungiStudente(AggiungiStudenteRequestDTO request){

        Studente s = sMapper.fromAggiungiStudenteRequestDTO(request);
        s.setCorso(cService.getCorso(request.getIdCorso()));
        sService.aggiungiStudente(s);
    }


    public void modificaStudente(ModificaStudenteRequestDTO request){
        Studente s = sService.getStudente(request.getId());
        s.setNome(request.getNome());
        s.setCognome(request.getCognome());
        s.setCorso(cService.getCorso(request.getIdCorso()));

        sService.modificaStudente(s);
    }

    public void eliminaStudente(Long idStudente){

        sService.eliminaStudente(idStudente);
    }

    public StudenteResponseDTO getStudente(long id){
        return sMapper.toStudenteResponseDTO(sService.getStudente(id));
    }

    public List<StudenteResponseDTO> getAllStudenti(){
        return sMapper.toStudenteResponseListDTO(sService.getStudenti());
    }

}
