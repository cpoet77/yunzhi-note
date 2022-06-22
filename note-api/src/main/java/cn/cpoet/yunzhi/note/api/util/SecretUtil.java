package cn.cpoet.yunzhi.note.api.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 加密工具
 *
 * @author CPoet
 */
public class SecretUtil {
    public final static String ALGORITHM_RSA = "RSA";

    public final static String ALGORITHM_DES = "DES";

    private SecretUtil() {
    }

    public static KeyPair genKeyPair() throws GeneralSecurityException {
        return KeyPairGenerator.getInstance(ALGORITHM_RSA).generateKeyPair();
    }

    public static SecretKey genSecretKey() throws GeneralSecurityException {
        return KeyGenerator.getInstance(ALGORITHM_DES).generateKey();
    }

    public static String encodeKey(Key key) {
        return toBase64(key.getEncoded());
    }

    public static PrivateKey decodePrivateKey(String privateKey) throws GeneralSecurityException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ofBase64(privateKey));
        return KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(pkcs8EncodedKeySpec);
    }

    public static PublicKey decodePublicKey(String publicKey) throws GeneralSecurityException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ofBase64(publicKey));
        return KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(x509EncodedKeySpec);
    }

    public static SecretKey decodeSecretKey(String secretKey) {
        return new SecretKeySpec(ofBase64(secretKey), ALGORITHM_DES);
    }

    public static String encrypt(PublicKey publicKey, String plaintext) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(ALGORITHM_RSA);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return toBase64(cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8)));
    }

    public static String decrypt(PrivateKey privateKey, String ciphertext) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(ALGORITHM_RSA);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(ofBase64(ciphertext)));
    }

    public static String encrypt(SecretKey secretKey, String plaintext) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return toBase64(cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8)));
    }

    public static String decrypt(SecretKey secretKey, String ciphertext) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(ofBase64(ciphertext)));
    }

    public static String toBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static byte[] ofBase64(String data) {
        return Base64.getDecoder().decode(data);
    }
}
