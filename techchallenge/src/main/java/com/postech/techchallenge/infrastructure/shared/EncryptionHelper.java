package com.postech.techchallenge.infrastructure.shared;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

@Slf4j
@Component
public class EncryptionHelper {

    @Value("${database.encryption-key}")
    private final String secretKey;

    private static final String DEFAULT_ALGORITH = "AES";

    private static final String DEFAULT_CIPHER = "AES/ECB/PKCS5Padding";

    public EncryptionHelper(@Value("${database.encryption-key}") String secretKey) {
        this.secretKey = secretKey;
    }

    @SneakyThrows
    public String encrypt(final String sensitive) {
        if (sensitive == null) {
            return null;
        }
        log.info("Encrypting sensitive data");
        final Key key = new SecretKeySpec(secretKey.getBytes(), DEFAULT_ALGORITH);
        final Cipher c = Cipher.getInstance(DEFAULT_CIPHER);
        c.init(Cipher.ENCRYPT_MODE, key);
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
