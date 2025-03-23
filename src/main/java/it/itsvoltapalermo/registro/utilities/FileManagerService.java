package it.itsvoltapalermo.registro.utilities;

import it.itsvoltapalermo.registro.converters.FileEncryptorConverter;
import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileManagerService {

    private final FileEncryptorConverter fileEncryptorConverter;

    public String uploadFile(String pathFolder, MultipartFile file) {
        if (file.isEmpty()) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "file", "Vuoto");

        try {
            String randomFileName = UUID.randomUUID().toString();

            byte[] encryptedBytes = fileEncryptorConverter.encrypt(file.getBytes());

            Path path = Paths.get(pathFolder + File.separator + randomFileName);
            Files.write(path, encryptedBytes);

            return randomFileName;

        } catch (Exception e) {
            throw new CustomResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "file", "Errore durante il salvataggio del file");
        }
    }

    public String uploadFile(String pathFolder, byte [] file) {
        if (file == null) throw new CustomResponseStatusException(HttpStatus.BAD_REQUEST, "file", "Vuoto");

        try {
            String randomFileName = UUID.randomUUID().toString();

            byte[] encryptedBytes = fileEncryptorConverter.encrypt(file);

            Path path = Paths.get(pathFolder + File.separator + randomFileName);
            Files.write(path, encryptedBytes);

            return randomFileName;

        } catch (Exception e) {
            throw new CustomResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "file", "Errore durante il salvataggio del file");
        }
    }

    public void deleteFile(String path) {
        try {
            Files.delete(Paths.get(path));
        } catch (IOException e) {
            throw new CustomResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "file", "Errore durante l'eliminazione del file");
        }
    }

    public byte[] downloadFile(String path) {
        try {
            byte[] encryptedBytes = Files.readAllBytes(Paths.get(path));

            return fileEncryptorConverter.decrypt(encryptedBytes);
        } catch (Exception e) {
            throw new CustomResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "file", "Errore durante il download del file");
        }
    }
}
