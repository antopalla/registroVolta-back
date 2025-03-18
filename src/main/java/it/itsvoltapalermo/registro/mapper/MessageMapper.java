package it.itsvoltapalermo.registro.mapper;

import it.itsvoltapalermo.registro.dto.response.errors.DoubleAttributeDTO;
import it.itsvoltapalermo.registro.dto.response.errors.MessageDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageMapper {

    public MessageDTO toMessageDto(DoubleAttributeDTO errore){
        MessageDTO mDTO=new MessageDTO();
        List<DoubleAttributeDTO> messages=new ArrayList<>();
        messages.add(errore);
        mDTO.setMessage(messages);
        mDTO.setData(LocalDateTime.now());
        return mDTO;
    }

    public MessageDTO toMessageDto(List<DoubleAttributeDTO> errore){
        MessageDTO mDTO=new MessageDTO();
        mDTO.setMessage(errore);
        mDTO.setData(LocalDateTime.now());
        return mDTO;
    }

    public DoubleAttributeDTO toDoubleAttribute(String campo,String message){
        DoubleAttributeDTO d=new DoubleAttributeDTO();
        d.setCampo(campo);
        d.setErrore(message);
        return d;
    }

    public DoubleAttributeDTO toDoubleAttribute(FieldError f){
        return toDoubleAttribute(f.getField(),f.getDefaultMessage());
    }
}
