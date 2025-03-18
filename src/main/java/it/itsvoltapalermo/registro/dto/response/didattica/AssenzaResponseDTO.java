package it.itsvoltapalermo.registro.dto.response.didattica;

import lombok.Data;

import java.sql.Time;

@Data
public class AssenzaResponseDTO {
    private long id;
    private Time durata;
}
