package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.CambiaPasswordRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.LoginRequestDTO;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.service.def.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class AuthFacade {

    private final AuthService uService;

    public Utente login(LoginRequestDTO requestDTO) {
        return uService.login(requestDTO.getUsername(), requestDTO.getPassword());
    }

    public void cambiaPassword(CambiaPasswordRequestDTO requestDTO, Utente u) {
        if (u.isDisattivato()) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        if (!u.getPassword().equals(requestDTO.getVecchiaPassword())) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        if (!requestDTO.getNuovaPassword().equals(requestDTO.getNuovaPasswordRipetuta())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le password non coincidono!");

        u.setPassword(requestDTO.getNuovaPassword());
        uService.modificaUtente(u);
    }
}
