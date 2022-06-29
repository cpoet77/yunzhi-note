package cn.cpoet.yunzhi.note.comm.filter;

import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.comm.util.UUIDUtil;
import org.springframework.boot.web.reactive.filter.OrderedWebFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 链路追踪信息添加
 *
 * @author CPoet
 */
public class ReactiveTraceWebFilter implements OrderedWebFilter {

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String traceId = headers.getFirst(SystemConst.TRACE_ID);
        if (!StringUtils.hasText(traceId)) {
            headers.set(SystemConst.TRACE_ID, UUIDUtil.randomPure());
        }
        String spanId = headers.getFirst(SystemConst.SPAN_ID);
        headers.set(SystemConst.SPAN_PRE_ID, spanId);
        headers.set(SystemConst.SPAN_ID, UUIDUtil.randomPure());
        return chain.filter(exchange);
    }
}
