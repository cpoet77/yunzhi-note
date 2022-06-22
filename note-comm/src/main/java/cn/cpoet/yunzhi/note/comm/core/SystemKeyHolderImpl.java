package cn.cpoet.yunzhi.note.comm.core;

import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
import lombok.RequiredArgsConstructor;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 密钥管理
 *
 * @author CPoet
 */
@RequiredArgsConstructor
public class SystemKeyHolderImpl implements SystemKeyHolder {
    private final KeyPair keyPair;
    private final SecretKey secretKey;

    @Override
    public KeyPair getRsaKeyPair() {
        return keyPair;
    }

    @Override
    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }

    @Override
    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    @Override
    public SecretKey getSecretKey() {
        return secretKey;
    }
}
