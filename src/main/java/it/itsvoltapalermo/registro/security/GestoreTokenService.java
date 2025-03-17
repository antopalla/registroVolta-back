package it.itsvoltapalermo.registro.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.service.def.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class GestoreTokenService {

    private final UtenteService service;

    @Value("${mia.chiave.per.jwt}")
    private String testoChiave;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(testoChiave.getBytes());
    }

    public String creaTokenUtente (Utente u) {
        long dieciGiorni = 1000L * 60 * 60 * 24 * 10;

        return Jwts.builder()
                .claims()
                .subject(u.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + dieciGiorni))
                .add("ruolo", u.getRuolo())
                .and()
                .signWith(getSecretKey())
                .compact();
    }

    private Claims getClaims(String token) {
        if (token == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        try {
            return Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    public Date getCreationDate (String token)  {
        return getClaims(token).getIssuedAt();
    }

    public Ruolo getRuolo (String token)  {
        return (Ruolo)getClaims(token).get("ruolo");
    }

    public LocalDateTime getExpirationDate (String token)  {
        Date d = getClaims(token).getExpiration();
        return LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
    }

    public Utente getUtente (String token) {
        return service.getByUsername(getClaims(token).getSubject());
    }


}
