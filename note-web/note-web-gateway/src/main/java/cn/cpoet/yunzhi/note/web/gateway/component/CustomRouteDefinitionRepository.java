package cn.cpoet.yunzhi.note.web.gateway.component;

import cn.cpoet.yunzhi.note.web.gateway.service.RouterService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 自定义网关路由持久化
 *
 * @author CPoet
 */
@Primary
@Component
@RequiredArgsConstructor
public class CustomRouteDefinitionRepository implements RouteDefinitionRepository {

    private final RouterService routerService;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return routerService.getRoutes();
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return routerService.save(route);
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routerService.delete(routeId);
    }
}
