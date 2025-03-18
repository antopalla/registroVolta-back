package it.itsvoltapalermo.registro.facade;

import it.itsvoltapalermo.registro.dto.request.utenze.CambiaPasswordRequestDTO;
import it.itsvoltapalermo.registro.dto.request.utenze.LoginRequestDTO;
import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.service.def.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class AuthFacade {

    private final AuthService uService;
    private final PasswordEncoder passwordEncoder;

    public Utente login(LoginRequestDTO requestDTO) {
        Utente u = uService.getByUsername(requestDTO.getUsername());
        if (u.isDisattivato()) throw new CustomResponseStatusException(HttpStatus.UNAUTHORIZED, "utente", "Username errato");
        if (!passwordEncoder.matches(requestDTO.getPassword(), u.getPassword())) throw new CustomResponseStatusException(HttpStatus.FORBIDDEN, "password", "Password errata");
        return u;
    }

    public void cambiaPassword(CambiaPasswordRequestDTO requestDTO, Utente u) {
        if (u.isDisattivato()) throw new CustomResponseStatusException(HttpStatus.UNAUTHORIZED, "utente", "Utente non presente");

        if (!passwordEncoder.matches(requestDTO.getVecchiaPassword(), u.getPassword())) throw new CustomResponseStatusException(HttpStatus.FORBIDDEN, "password", "Password errata");

        if (!requestDTO.getNuovaPassword().equals(requestDTO.getNuovaPasswordRipetuta())) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "password", "Le password non coincidono");

        u.setPassword(passwordEncoder.encode(requestDTO.getNuovaPassword()));
        uService.modificaUtente(u);
    }
}
