package cn.cpoet.yunzhi.note.auth.configuration;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.auth.configuration.auto.AuthenticateProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * 认证配置
 *
 * @author CPoet
 */
@ComponentScan(basePackages = "cn.cpoet.yunzhi.note.auth.aspect")
@RequiredArgsConstructor
public class AuthenticateConfig {
    @Bean
    @ConfigurationProperties(prefix = "note.auth")
    public AuthenticateProperties authenticateProperties() {
        return new AuthenticateProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthContext authContext(AuthenticateProperties authenticateProperties) {
        return null;
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Subject contextSubject(AuthContext authContext) {
        return authContext.getSubject();
    }
}
