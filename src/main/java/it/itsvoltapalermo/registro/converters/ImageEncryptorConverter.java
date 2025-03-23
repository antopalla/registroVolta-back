package it.itsvoltapalermo.registro.converters;

import it.itsvoltapalermo.registro.exceptions.CustomResponseStatusException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

@Component
@Converter
public class ImageEncryptorConverter implements AttributeConverter<byte[], byte[]> {

    @Value("${mia.chiave.per.cifrare}")
    private String SECRET_KEY;


    private SecretKeySpec getSecretKeySpec() {
        // Decodifica la chiave da Base64
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);
        // Se vuoi usare AES-256, la chiave deve essere lunga 32 byte
        if (keyBytes.length != 16 && keyBytes.length != 24 && keyBytes.length != 32) {
            // In questo esempio, troncando o estendendo i byte fino a 32, usiamo AES-256.
            keyBytes = Arrays.copyOf(keyBytes, 32);
        }
        return new SecretKeySpec(keyBytes, "AES");
    }

    @Override
    public byte[] convertToDatabaseColumn(byte[] attribute) {
        if (attribute == null) return null;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec key = getSecretKeySpec();
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(attribute);
        } catch (Exception e) {
            throw new CustomResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "dbconverter", "Errore nella cifratura dell'immagine");
        }
    }

    @Override
    public byte[] convertToEntityAttribute(byte[] dbData) {
        if (dbData == null) return null;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec key = getSecretKeySpec();
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(dbData);
        } catch (Exception e) {
            throw new CustomResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "dbconverter", "Errore nella decifratura dell'immagine");
        }
    }
}

