package cn.cpoet.yunzhi.note.auth.resolver;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author CPoet
 */
public class AuthContextReactiveArgResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private AuthContext authContext;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return AuthContext.class == parameter.getParameterType();
    }

    @Override
    public Mono<Object> resolveArgument(MethodParameter parameter,
                                        BindingContext bindingContext,
                                        ServerWebExchange exchange) {
        return Mono.just(authContext);
    }
}
