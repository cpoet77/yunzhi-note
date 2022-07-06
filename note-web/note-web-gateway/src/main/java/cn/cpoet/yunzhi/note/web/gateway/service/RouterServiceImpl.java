package cn.cpoet.yunzhi.note.web.gateway.service;

import cn.cpoet.yunzhi.note.web.gateway.dto.RouterDTO;
import cn.cpoet.yunzhi.note.web.gateway.feign.RouterFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CPoet
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RouterServiceImpl implements RouterService, ApplicationListener<ApplicationReadyEvent> {

    private RouterFeign routerFeign;

    @Override
    public Flux<RouteDefinition> getRoutes() {
        return Flux
            .from(subscriber -> {
            })
            .map(this::transform2routeDefinition);

    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        this.routerFeign = event.getApplicationContext().getBean(RouterFeign.class);
    }

    private RouteDefinition transform2routeDefinition(RouterDTO router) {
        RouteDefinition route = new RouteDefinition();
        route.setId(String.valueOf(router.getId()));
        route.setUri(URI.create(router.getUri()));
        route.setOrder(router.getSorted());
        route.setMetadata(CollectionUtils.isEmpty(router.getMetadata()) ? Collections.emptyMap() : router.getMetadata());
        List<String> predicates = router.getPredicates();
        if (!CollectionUtils.isEmpty(predicates)) {
            List<PredicateDefinition> predicateDefinitions = predicates
                .stream()
                .map(PredicateDefinition::new)
                .collect(Collectors.toList());
            route.setPredicates(predicateDefinitions);
        }
        List<String> filters = router.getFilters();
        if (!CollectionUtils.isEmpty(filters)) {
            List<FilterDefinition> filterDefinitions = filters
                .stream()
                .map(FilterDefinition::new)
                .collect(Collectors.toList());
            route.setFilters(filterDefinitions);
        }
        return route;
    }
}
