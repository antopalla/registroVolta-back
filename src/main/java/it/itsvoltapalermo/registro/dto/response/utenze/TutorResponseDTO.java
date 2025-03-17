package it.itsvoltapalermo.registro.dto.response.utenze;

import lombok.Data;

@Data
public class TutorResponseDTO {

    private long id;
    private String nome;
    private String cognome;
    private String username;
    private String ruolo;

}
