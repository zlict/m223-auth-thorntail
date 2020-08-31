package ch.zli.m223.example.auth;

import com.google.common.io.Resources;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;

public class Settings {
    private static final String PRIVATE_KEY = "security/private.der";
    public static Key getPrivateKey() throws Exception {
        try {
            byte[] keyBytes = Resources.toByteArray(Resources.getResource(PRIVATE_KEY));
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(spec);
        } catch (Exception e) {
            throw new Exception("Couldn't load private key");
        }
    }

    public static final int TOKEN_EXPIRATION_TIME = 1000 * 60 * 60 * 24;
    public static final int HASH_ITERATIONS = 10000;
    public static final int SALT_LENGTH = 32;
    public static final int HASH_LENGTH = 256;
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";
    public static final String TOKEN_ISSUER = "ch.zli.m223.example.auth";
}
