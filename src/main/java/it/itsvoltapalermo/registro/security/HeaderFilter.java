package it.itsvoltapalermo.registro.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro che viene eseguito una sola volta per ogni richiesta.
 * Il filtro aggiunge specifici header HTTP alla risposta per abilitare il CORS (Cross-Origin Resource Sharing).
 */
@Component
public class HeaderFilter extends OncePerRequestFilter {

    /**
     * Metodo che intercetta la richiesta e la risposta per aggiungere gli header necessari al CORS.
     *
     * @param request la richiesta HTTP in ingresso
     * @param response la risposta HTTP in uscita
     * @param filterChain la catena di filtri da eseguire
     * @throws ServletException in caso di errori nel filtro
     * @throws IOException in caso di errori di I/O
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Aggiunge l'header che consente a qualsiasi origine di accedere alle risorse
        response.addHeader("Access-Control-Allow-Origin", "*");
        // Aggiunge l'header che permette a qualsiasi header di essere utilizzato nelle richieste
        response.addHeader("Access-Control-Allow-Headers", "*");
        // Aggiunge l'header che specifica i metodi HTTP consentiti
        response.addHeader("Access-Control-Allow-Methods", "DELETE, POST, GET, OPTIONS, PUT");
        // Aggiunge l'header che espone tutti gli header nelle risposte
        response.addHeader("Access-Control-Expose-Headers", "*");
        // Prosegue con la catena dei filtri
        filterChain.doFilter(request, response);
    }
}
