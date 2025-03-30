package it.itsvoltapalermo.registro.dto.response.didattica;

import lombok.Data;

@Data
public class AssenzaResponseDTO {
    private long id;
    private double durata;
    private long idStudente;
    private long idLezione;
}
