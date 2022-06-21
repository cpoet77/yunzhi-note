package cn.cpoet.yunzhi.note.auth.resolver;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 认证主体方法参数解析器
 *
 * @author CPoet
 */
@RequiredArgsConstructor
public class SubjectArgumentResolver implements HandlerMethodArgumentResolver {
    private final ApplicationContext applicationContext;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return Subject.class == methodParameter.getParameterType();
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        return applicationContext.getBean(Subject.class);
    }
}
