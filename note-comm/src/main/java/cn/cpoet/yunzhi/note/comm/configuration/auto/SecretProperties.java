package cn.cpoet.yunzhi.note.comm.configuration.auto;

import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
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
    private String privateKey = SystemKeyHolder.DEFAULT_PRIVATE_KEY;

    /**
     * 系统级加密-公钥
     */
    private String publicKey = SystemKeyHolder.DEFAULT_PUBLIC_KEY;

    /**
     * 系统级加密-密钥
     */
    private String secretKey = SystemKeyHolder.DEFAULT_SECRET_KEY;
}
