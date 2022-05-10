package cn.wanggf.yunzhi.note.auth.configuration.auto;

import lombok.Data;

/**
 * @author wanggf
 */
@Data
public class HmacProperties {
    /**
     * 是否随机key
     */
    private Boolean random = Boolean.TRUE;

    /**
     * 用于加密token的base64串
     * <p>如果不建议用户状态的维持，单机建议采用随机生成的方法，或者使用相对安全的RSA</p>
     * <code>JGxsemVyby1iZi3miJHniLHkvaAt6YeR5Ly25L+QLeadpeiHquKAnOeOi+WbveWvjOKAnSQ=</code>
     */
    private String secretKey;
}
