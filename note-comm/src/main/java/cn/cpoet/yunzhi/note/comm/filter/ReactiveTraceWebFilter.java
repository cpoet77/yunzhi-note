package cn.cpoet.yunzhi.note.comm.filter;

import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.api.core.AppContext;
import cn.cpoet.yunzhi.note.api.core.TraceInfo;
import cn.cpoet.yunzhi.note.comm.core.ReactiveRequestWrapper;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.filter.OrderedWebFilter;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 链路追踪信息添加
 *
 * @author CPoet
 */
public class ReactiveTraceWebFilter implements OrderedWebFilter {
    @Autowired
    private AppContext appContext;

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        // 获取链路信息
        TraceInfo traceInfo = appContext.getTraceInfo(ReactiveRequestWrapper.wrapper(exchange));
        // 将链路信息存储至MDC中
        MDC.put(SystemConst.SPAN_ID, String.valueOf(traceInfo.getSpanId()));
        MDC.put(SystemConst.TRACE_ID, traceInfo.getTraceId());
        return chain.filter(exchange);
    }
}
