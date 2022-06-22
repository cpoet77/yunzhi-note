package cn.cpoet.yunzhi.note.comm.configuration.auto;

import lombok.Data;

/**
 * 密钥配置
 *
 * @author CPoet
 */
@Data
public class SecretProperties {
    /**
     * 系统级加密-私钥
     */
    private String privateKey;

    /**
     * 系统级加密-公钥
     */
    private String publicKey;

    /**
     * 系统级加密-密钥
     */
    private String secretKey;
}
