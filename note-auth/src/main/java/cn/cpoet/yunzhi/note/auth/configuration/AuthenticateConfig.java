package cn.cpoet.yunzhi.note.auth.configuration;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import cn.cpoet.yunzhi.note.auth.configuration.auto.AuthenticateProperties;
import cn.cpoet.yunzhi.note.auth.core.SimpleAuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * 认证配置
 *
 * @author CPoet
 */
@RequiredArgsConstructor
@Import({AuthenticateReactiveConfig.class, AuthenticateServletConfig.class})
public class AuthenticateConfig {
    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "note.auth")
    public AuthenticateProperties authenticateProperties() {
        return new AuthenticateProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthContext authContext(RequestWrapper requestWrapper) {
        return new SimpleAuthContext(requestWrapper);
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Subject contextSubject(AuthContext authContext) {
        return authContext.getSubject();
    }
}
