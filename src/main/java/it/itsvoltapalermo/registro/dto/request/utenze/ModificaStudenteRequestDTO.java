package it.itsvoltapalermo.registro.dto.request.utenze;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModificaStudenteRequestDTO extends ModificaUtenteRequestDTO {

    //@NotNull(message = "Lo studente deve appartenere a un corso")
    private long idCorso;
    //@NotNull(message = "Lo studente deve avere un diario di bordo")
    private long idDiario;
}
