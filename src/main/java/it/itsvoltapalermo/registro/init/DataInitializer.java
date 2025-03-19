package it.itsvoltapalermo.registro.init;

import it.itsvoltapalermo.registro.model.Ruolo;
import it.itsvoltapalermo.registro.model.Tutor;
import it.itsvoltapalermo.registro.repository.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final UtenteRepository repo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (repo.count() == 0) {
            System.out.println("DataInitializer: repo.count() == 0, creazione tutor admin");
            Tutor admin = new Tutor();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRuolo(Ruolo.ADMIN);
            repo.save(admin);

            System.out.println("DataInitializer: Utente admin creato.");
        }
    }
}
