package it.itsvoltapalermo.registro.dto.request.utenze;

import lombok.Data;

@Data
public class ModificaStudenteRequestDTO extends ModificaUtenteRequestDTO {

    private long idCorso;
}
