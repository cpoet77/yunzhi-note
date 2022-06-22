package cn.cpoet.yunzhi.note.auth.resolver;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.comm.core.ReactiveRequestWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author CPoet
 */
@RequiredArgsConstructor
public class SubjectReactiveArgResolver implements HandlerMethodArgumentResolver {
    private final AuthContext authContext;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Subject.class == parameter.getParameterType();
    }

    @Override
    public Mono<Object> resolveArgument(MethodParameter parameter,
                                        BindingContext bindingContext,
                                        ServerWebExchange exchange) {
        return Mono.just(authContext.getSubject(ReactiveRequestWrapper.wrapper(exchange.getRequest())));
    }
}
