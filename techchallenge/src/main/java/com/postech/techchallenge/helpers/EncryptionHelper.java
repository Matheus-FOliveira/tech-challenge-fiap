package com.postech.techchallenge.helpers;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

@Slf4j
@AllArgsConstructor
public class EncryptionHelper {

    /*
    secretKey = palavra chave que sera usada para encryptar e desencriptar os dados
    não deve ser setada hardcoded no codigo dessa forma, idealmente deve ser salva em uma secret vault do ambiente
    mas devemos ver isso quando chegarmos na materia de security, eu acho.
    por hora, podemos setar aqui mesmo, ou no arquivo properties.
     */
    private final String secretKey = "chave secreta";

    private static final String DEFAULT_ALGORITH = "AES";

    private static final String DEFAULT_CIPHER = "AES/ECB/PKCS5Padding";

    @SneakyThrows
    public String encrypt(final String sensitive) {
        if (sensitive == null) {
            return null;
        }
        log.info("Encrypting sensitive data");
        final Key key = new SecretKeySpec(secretKey.getBytes(), DEFAULT_ALGORITH);
        final Cipher c = Cipher.getInstance(DEFAULT_CIPHER);
        c.init(Cipher.DECRYPT_MODE, key);
        return new String(Base64.getEncoder().encode(c.doFinal(sensitive.getBytes())), StandardCharsets.UTF_8);
    }

    @SneakyThrows
    public String decrypt (final String sensitve) {
        if (sensitve == null) {
            return null;
        }
        log.info("Decrypting sensitive data");
        final Key key = new SecretKeySpec(secretKey.getBytes(), DEFAULT_ALGORITH);
        final Cipher c = Cipher.getInstance(DEFAULT_CIPHER);
        c.init(Cipher.DECRYPT_MODE, key);
        return new String(c.doFinal(Base64.getDecoder().decode(sensitve.getBytes(StandardCharsets.UTF_8))));
    }
}
