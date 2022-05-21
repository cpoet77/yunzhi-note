package cn.wanggf.yunzhi.note.auth.configuration;

import cn.wanggf.yunzhi.note.auth.configuration.auto.AuthenticateProperties;
import cn.wanggf.yunzhi.note.auth.core.AuthContext;
import cn.wanggf.yunzhi.note.auth.interceptor.AuthenticateInterceptor;
import cn.wanggf.yunzhi.note.auth.resolver.AuthContextArgumentResolver;
import cn.wanggf.yunzhi.note.auth.resolver.SubjectArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

/**
 * 解析器相关配置
 *
 * @author wanggf
 */
@RequiredArgsConstructor
public class AuthWebMvcConfig implements WebMvcConfigurer {
    private final AuthContext authContext;
    private final ApplicationContext applicationContext;
    private final AuthenticateProperties authenticateProperties;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new SubjectArgumentResolver(applicationContext));
        resolvers.add(new AuthContextArgumentResolver(applicationContext));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> authUrl = authenticateProperties.getAuthUrl();
        List<String> ignoredAuthUrl = authenticateProperties.getIgnoredAuthUrl();
        registry
            .addInterceptor(new AuthenticateInterceptor(authContext, authenticateProperties))
            .addPathPatterns(CollectionUtils.isEmpty(authUrl) ? Collections.emptyList() : authUrl)
            .excludePathPatterns(CollectionUtils.isEmpty(ignoredAuthUrl) ? Collections.emptyList() : ignoredAuthUrl);
    }
}
