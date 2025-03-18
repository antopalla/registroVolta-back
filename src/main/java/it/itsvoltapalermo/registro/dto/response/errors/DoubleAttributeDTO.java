package it.itsvoltapalermo.registro.dto.response.errors;

import lombok.Data;

@Data
public class DoubleAttributeDTO implements Comparable<DoubleAttributeDTO> {
    private String campo;
    private String errore;


    @SuppressWarnings("NullableProblems")
    @Override
    public int compareTo(DoubleAttributeDTO o) {
        if(o==null) return -1;
        return campo==null?o.campo==null?0:-1:campo.compareToIgnoreCase(o.campo);
    }
}
