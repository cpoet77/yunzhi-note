package cn.cpoet.yunzhi.note.auth.configuration;

import cn.cpoet.yunzhi.note.auth.configuration.auto.AuthenticateProperties;
import cn.cpoet.yunzhi.note.auth.core.AuthContext;
import cn.cpoet.yunzhi.note.auth.core.Subject;
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
@ComponentScan(basePackages = "cn.wanggf.yunzhi.note.auth.aspect")
@RequiredArgsConstructor
public class AuthenticateConfig {
    @Bean
    @ConfigurationProperties(prefix = "donkey.blog.auth")
    public AuthenticateProperties authenticateProperties() {
        return new AuthenticateProperties();
    }

    @Bean({"defaultAuthContext", "simpleAuthContext"})
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
