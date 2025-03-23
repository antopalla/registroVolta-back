package it.itsvoltapalermo.registro.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

@Component
public class FileEncryptorConverter {

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

    public byte[] encrypt(byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKeySpec());
        return cipher.doFinal(input);
    }

    public byte[] decrypt(byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, getSecretKeySpec());
        return cipher.doFinal(input);
    }

}
