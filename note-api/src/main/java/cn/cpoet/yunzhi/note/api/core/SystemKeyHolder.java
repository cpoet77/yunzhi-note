package cn.cpoet.yunzhi.note.api.core;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 系统安全类密钥
 * <p>非对称算法使用RSA，对称算法使用DES</p>
 *
 * @author CPoet
 */
public interface SystemKeyHolder {
    /**
     * 获取密钥对
     *
     * @return 密钥对
     */
    KeyPair getRsaKeyPair();

    /**
     * 获取私钥
     *
     * @return 私钥
     */
    PrivateKey getPrivateKey();

    /**
     * 获取公钥
     *
     * @return 公钥
     */
    PublicKey getPublicKey();

    /**
     * 获取密钥
     *
     * @return 密钥
     */
    SecretKey getSecretKey();
}
