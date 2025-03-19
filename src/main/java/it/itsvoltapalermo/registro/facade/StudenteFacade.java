package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.AggiungiStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.ModificaStudenteRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.StudenteAssenzeResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.StudenteResponseDTO;
import it.itsvoltapalermo.registro.mapper.AssenzaMapper;
import it.itsvoltapalermo.registro.mapper.StudenteMapper;
import it.itsvoltapalermo.registro.model.Assenza;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Studente;
import it.itsvoltapalermo.registro.service.def.AssenzaService;
import it.itsvoltapalermo.registro.service.def.CorsoService;
import it.itsvoltapalermo.registro.service.def.StudenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudenteFacade {

    private final StudenteMapper sMapper;
    private final StudenteService sService;
    private final CorsoService cService;
    private final AssenzaService aService;
    private final AssenzaMapper aMapper;
    private final PasswordEncoder passwordEncoder;

    public void aggiungiStudente(AggiungiStudenteRequestDTO request){
        Studente s = sMapper.fromAggiungiStudenteRequestDTO(request);
        s.setCorso(cService.getCorso(request.getIdCorso()));
        s.setRuolo(Ruolo.STUDENTE);
        s.setPassword(passwordEncoder.encode(request.getPassword()));

        sService.aggiungiStudente(s);
    }


    public void modificaStudente(ModificaStudenteRequestDTO request){
        Studente s = sService.getStudente(request.getId());
        s.setNome(request.getNome());
        s.setCognome(request.getCognome());
        s.setCorso(cService.getCorso(request.getIdCorso()));
        s.setCodiceFiscale(request.getCodiceFiscale());
        s.setDataNascita(request.getDataNascita());
        s.setUsername(request.getUsername());

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

    public List<StudenteResponseDTO> getStudentiByClasse(long id){
        return sMapper.toStudenteResponseListDTO(sService.getStudentiByCorso(id));
    }

    public List<StudenteAssenzeResponseDTO> getStudentiByOreAssenza(int oreAssenza) {
        List<Studente> studenti = sService.getStudentiByOreAssenza(oreAssenza);
        List<StudenteAssenzeResponseDTO> studentiAssenze = new ArrayList<>();

        for(Studente s: studenti) {
            StudenteAssenzeResponseDTO sDTO = new StudenteAssenzeResponseDTO();
            sDTO.setId(s.getId());
            sDTO.setNome(s.getNome());
            sDTO.setCognome(s.getCognome());
            sDTO.setTotaleOreAssenza(s.getAssenze().stream().mapToDouble(Assenza::getDurata).sum());
            sDTO.setAssenze(aMapper.toAssenzaResponseDTOList(aService.getAssenzeByStudente(s.getId())));
            studentiAssenze.add(sDTO);
        }

        return studentiAssenze;
    }
}
