package cn.wanggf.yunzhi.note.auth.configuration;

import cn.wanggf.yunzhi.note.auth.configuration.auto.AuthenticateProperties;
import cn.wanggf.yunzhi.note.auth.core.AuthContext;
import cn.wanggf.yunzhi.note.auth.core.SimpleAuthContext;
import cn.wanggf.yunzhi.note.auth.core.Subject;
import cn.wanggf.yunzhi.note.auth.core.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 认证配置
 *
 * @author wanggf
 */
@ComponentScan(basePackages = "cn.wanggf.yunzhi.note.auth.aspect")
@ImportAutoConfiguration({AuthValidatorConfig.class, AuthWebMvcConfig.class})
@RequiredArgsConstructor
public class AuthenticateConfig {
    @Bean
    @ConfigurationProperties(prefix = "donkey.blog.auth")
    public AuthenticateProperties authenticateProperties() {
        return new AuthenticateProperties();
    }

    @Bean({"defaultAuthContext", "simpleAuthContext"})
    @ConditionalOnMissingBean
    public AuthContext authContext(AuthenticateProperties authenticateProperties, List<Validator> validators) {
        AuthContext context = new SimpleAuthContext(authenticateProperties);
        if (!CollectionUtils.isEmpty(validators)) {
            validators.forEach(context::addValidator);
        }
        return context;
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Subject contextSubject(AuthContext authContext) {
        return authContext.getSubject();
    }
}
