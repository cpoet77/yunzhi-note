package cn.cpoet.yunzhi.note.auth.resolver;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 认证上下文方法参数注入
 *
 * @author CPoet
 */
public class AuthContextArgResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private AuthContext authContext;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return AuthContext.class == methodParameter.getParameterType();
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        return authContext;
    }
}
