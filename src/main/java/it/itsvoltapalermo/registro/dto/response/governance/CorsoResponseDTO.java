package it.itsvoltapalermo.registro.dto.response.governance;

import it.itsvoltapalermo.registro.dto.response.didattica.LezioneResponseDTO;
import it.itsvoltapalermo.registro.dto.response.utenze.StudenteResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CorsoResponseDTO {

    private long id;
    private String nome;
    private String descrizione;

    private String sede;
    private String tutor;

    //private List<StudenteResponseDTO> studenti;
    //private List<LezioneResponseDTO> lezioni;

    //TODO decidere come gestire le liste

}
