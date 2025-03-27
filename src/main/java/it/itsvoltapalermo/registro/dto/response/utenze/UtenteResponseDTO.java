package it.itsvoltapalermo.registro.dto.response.utenze;

import lombok.Data;

@Data
public class UtenteResponseDTO {

    private long id;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String codiceFiscale;

    //TODO in teoria no
    //private String username;
    //private String ruolo;
}
