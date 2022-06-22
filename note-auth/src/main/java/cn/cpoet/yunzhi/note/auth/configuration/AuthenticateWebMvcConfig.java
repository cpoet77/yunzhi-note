package cn.cpoet.yunzhi.note.auth.configuration;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.auth.resolver.AuthContextArgResolver;
import cn.cpoet.yunzhi.note.auth.resolver.SubjectArgResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author CPoet
 */
@RequiredArgsConstructor
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class AuthenticateWebMvcConfig implements WebMvcConfigurer {
    private final AuthContext authContext;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new AuthContextArgResolver(authContext));
        resolvers.add(new SubjectArgResolver(authContext));
    }
}
