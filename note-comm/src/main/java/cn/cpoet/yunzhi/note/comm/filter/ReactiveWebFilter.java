package cn.cpoet.yunzhi.note.comm.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.filter.OrderedWebFilter;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * ReactiveWeb拦截器
 *
 * @author CPoet
 */
@Slf4j
public class ReactiveWebFilter implements OrderedWebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
