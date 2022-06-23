package cn.cpoet.yunzhi.note.auth.resolver;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.comm.core.ServletRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证主体方法参数解析器
 *
 * @author CPoet
 */
public class SubjectArgResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private AuthContext authContext;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return Subject.class == methodParameter.getParameterType();
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        return authContext.getSubject(ServletRequestWrapper.wrapper(request));
    }
}
