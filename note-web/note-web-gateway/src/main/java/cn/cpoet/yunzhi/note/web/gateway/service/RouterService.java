package cn.cpoet.yunzhi.note.web.gateway.service;

import org.springframework.cloud.gateway.route.RouteDefinition;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author CPoet
 */
public interface RouterService {
    Flux<RouteDefinition> getRoutes();

    Mono<Void> save(Mono<RouteDefinition> route);

    Mono<Void> delete(Mono<String> routeId);
}
