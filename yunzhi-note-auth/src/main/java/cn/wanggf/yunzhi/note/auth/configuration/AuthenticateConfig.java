package cn.wanggf.yunzhi.note.auth.configuration;

import cn.wanggf.yunzhi.note.auth.configuration.auto.AuthenticateProperties;
import cn.wanggf.yunzhi.note.auth.context.AuthContext;
import cn.wanggf.yunzhi.note.auth.context.SimpleAuthContext;
import cn.wanggf.yunzhi.note.auth.context.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * 认证配置
 *
 * @author wanggf
 */
@ComponentScan(basePackages = "cn.wanggf.donkey.blog.auth.aspect")
@ImportAutoConfiguration({AuthValidatorConfig.class, AuthValidatorChainConfig.class, AuthWebMvcConfig.class})
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
        return new SimpleAuthContext(authenticateProperties);
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Subject contextSubject(AuthContext authContext) {
        return authContext.getSubject();
    }
}
