package it.itsvoltapalermo.registro.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.itsvoltapalermo.registro.model.Utente;
import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.service.def.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Servizio per la gestione dei token JWT.
 * Questa classe è responsabile della creazione e validazione dei token JWT per l'autenticazione degli utenti.
 * Utilizza la libreria io.jsonwebtoken per costruire, firmare e analizzare i token.
 */
@Service
@RequiredArgsConstructor
public class GestoreTokenService {

    // Servizio per ottenere l'utente in base allo username (presente nel token)
    private final AuthService service;

    // Chiave segreta per la firma dei token, iniettata tramite la configurazione (application.properties o simili)
    @Value("${mia.chiave.per.jwt}")
    private String testoChiave;

    /**
     * Metodo che genera la chiave segreta utilizzata per firmare i token.
     *
     * @return una SecretKey generata dalla chiave segreta specificata
     */
    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(testoChiave.getBytes());
    }

    /**
     * Crea un token JWT per l'utente passato come parametro.
     * Il token include lo username come soggetto, la data di emissione, la data di scadenza,
     * e alcuni claim personalizzati come il ruolo e l'id dell'utente.
     *
     * @param u l'utente per cui creare il token
     * @return il token JWT in formato String
     */
    public String creaTokenUtente(Utente u) {
        // Durata del token in millisecondi (8 ore)
        long durata = 1000L * 60 * 60 * 8;

        return Jwts.builder()
                .claims() // Inizializza i claims del token
                .subject(u.getUsername()) // Imposta lo username come soggetto del token
                .issuedAt(new Date(System.currentTimeMillis())) // Data di emissione
                .expiration(new Date(System.currentTimeMillis() + durata)) // Data di scadenza (8 ore dopo)
                .add("ruolo", u.getRuolo()) // Aggiunge il ruolo dell'utente come claim personalizzato
                .and() // Termina la configurazione dei claims
                .signWith(getSecretKey()) // Firma il token con la chiave segreta
                .compact(); // Compatta e restituisce il token in formato String
    }

    /**
     * Estrae i Claims (dati) dal token JWT fornito.
     * Se il token è nullo o non valido, viene lanciata un'eccezione con status UNAUTHORIZED.
     *
     * @param token il token JWT da analizzare
     * @return i Claims estratti dal token
     */
    private Claims getClaims(String token) {
        // Se il token è nullo, lancia un'eccezione di accesso non autorizzato
        if (token == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        // Se il token inizia con "Bearer ", lo rimuove
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        try {
            // Analizza il token e restituisce i Claims utilizzando la chiave segreta
            return Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException e) {
            // In caso di errore nel parsing (token non valido, scaduto, ecc.)
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    /**
     * Restituisce la data di creazione (issuedAt) del token.
     *
     * @param token il token JWT da analizzare
     * @return la data di emissione del token
     */
    public Date getCreationDate(String token) {
        return getClaims(token).getIssuedAt();
    }

    /**
     * Estrae il ruolo dell'utente dal token.
     *
     * @param token il token JWT da analizzare
     * @return il ruolo (Ruolo) estratto dal token
     */
    public Ruolo getRuoloByToken(String token) {
        return (Ruolo) getClaims(token).get("ruolo");
    }

    /**
     * Restituisce la data di scadenza del token come LocalDateTime.
     *
     * @param token il token JWT da analizzare
     * @return la data di scadenza del token convertita in LocalDateTime
     */
    public LocalDateTime getExpirationDate(String token) {
        Date d = getClaims(token).getExpiration();
        return LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Recupera l'utente associato al token JWT.
     * Estrae lo username dal token e utilizza il servizio di autenticazione per ottenere l'utente corrispondente.
     *
     * @param token il token JWT da analizzare
     * @return l'oggetto Utente associato al token
     */
    public Utente getUtenteByToken(String token) {
        return service.getByUsername(getClaims(token).getSubject());
    }
}
