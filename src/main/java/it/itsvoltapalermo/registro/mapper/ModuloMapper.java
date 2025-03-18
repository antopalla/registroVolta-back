package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.request.didattica.AggiungiModuloRequestDTO;
import it.itsvoltapalermo.registro.dto.response.didattica.ModuloResponseDTO;
import it.itsvoltapalermo.registro.model.Modulo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModuloMapper {

    public Modulo fromAggiungiModuloRequestDTO (AggiungiModuloRequestDTO mDTO){
        Modulo m = new Modulo();
        m.setDenominazione(mDTO.getDenominazione());
        return m;
    }

    public ModuloResponseDTO toModuloResponseDTO (Modulo m){
        ModuloResponseDTO mDTO = new ModuloResponseDTO();
        mDTO.setId(m.getId());
        mDTO.setDenominazione(m.getDenominazione());
        return mDTO;
    }

    public List<ModuloResponseDTO> toModuloResponseDTOList (List<Modulo> moduli){
        List<ModuloResponseDTO> mDTOList = new ArrayList<>();
        for (Modulo m : moduli) {
            mDTOList.add(toModuloResponseDTO(m));
        }
        return mDTOList;
    }
}
