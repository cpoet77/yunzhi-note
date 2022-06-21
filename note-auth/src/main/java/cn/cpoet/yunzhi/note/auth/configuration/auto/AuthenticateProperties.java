package cn.cpoet.yunzhi.note.auth.configuration.auto;

import lombok.Data;

import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * 认证相关配置
 *
 * @author CPoet
 */
@Data
public class AuthenticateProperties {
    /**
     * token header中的名称
     */
    private String tokenHeader = "Authorization";

    /**
     * token的有效时长
     */
    private Duration tokenDuration = Duration.ofMinutes(120);

    /**
     * 刷新token区间
     */
    private Duration refreshTokenBwt = Duration.ofMinutes(10);

    /**
     * 刷新token标志头
     */
    private String refreshTokenHeader = "refreshToken";

    /**
     * 需要认证的url
     */
    private List<String> authUrl;

    /**
     * 跳过认证的url
     */
    private List<String> ignoredAuthUrl;

    /**
     * 访问权限匹配，当且仅当{@link #authUrl}有效时
     */
    private Map<String, AuthPermissionMatchProperties> authPermissionMatch;
}
