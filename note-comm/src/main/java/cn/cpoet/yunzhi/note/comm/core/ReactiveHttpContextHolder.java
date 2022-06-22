package cn.cpoet.yunzhi.note.comm.core;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author CPoet
 */
public class ReactiveHttpContextHolder {
    public final static Class<ServerWebExchange> CONTEXT_KEY = ServerWebExchange.class;

    public static Mono<ServerHttpRequest> getRequest() {
        return Mono.deferContextual(cv -> Mono.fromSupplier(() -> cv))
            .map(context -> context.get(CONTEXT_KEY).getRequest());
    }

    //获取当前response
    public static Mono<ServerHttpResponse> getResponse() {
        return Mono.subscriberContext()
            .map(context -> context.get(CONTEXT_KEY).getResponse());
    }
}
