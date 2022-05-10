package cn.wanggf.yunzhi.note.auth.resolver;

import cn.wanggf.yunzhi.note.auth.context.AuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 认证上下文方法参数注入
 *
 * @author wanggf
 */
@RequiredArgsConstructor
public class AuthContextArgumentResolver implements HandlerMethodArgumentResolver {
    private final ApplicationContext applicationContext;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return AuthContext.class == methodParameter.getParameterType();
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        return applicationContext.getBean(AuthContext.class);
    }
}
