package cn.cpoet.yunzhi.note.auth.configuration;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.auth.core.DefaultAuthContext;
import cn.cpoet.yunzhi.note.auth.resolver.AuthContextArgResolver;
import cn.cpoet.yunzhi.note.auth.resolver.SubjectArgResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author CPoet
 */
@RequiredArgsConstructor
@Import(AuthenticateWebMvcConfig.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class AuthenticateServletConfig {
    @Bean
    @ConditionalOnMissingBean
    public AuthContext authContext() {
        return new DefaultAuthContext();
    }

    @Bean
    public AuthContextArgResolver authContextArgResolver() {
        return new AuthContextArgResolver();
    }

    @Bean
    public SubjectArgResolver subjectArgResolver() {
        return new SubjectArgResolver();
    }
}
