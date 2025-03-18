package it.itsvoltapalermo.registro.dto.response.errors;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MessageDTO {
    private List<DoubleAttributeDTO> message;
    private LocalDateTime data;
}
