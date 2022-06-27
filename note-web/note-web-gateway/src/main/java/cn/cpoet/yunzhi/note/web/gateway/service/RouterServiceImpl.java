package cn.cpoet.yunzhi.note.web.gateway.service;

import cn.cpoet.yunzhi.note.web.gateway.dto.RouterDTO;
import cn.cpoet.yunzhi.note.web.gateway.feign.RouterFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author CPoet
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RouterServiceImpl implements RouterService, ApplicationEventPublisherAware, ApplicationListener<ApplicationReadyEvent> {
    private final static Object LOCK = new Object();

    private final RouterFeign routerFeign;
    private final RouteDefinitionWriter routeDefinitionWriter;

    private Set<Long> routerIds;
    private ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void syncRouter() {
        try {
            syncRemoteRouter();
        } catch (Exception e) {
            log.warn("远程路由信息同步失败：{}", e.getMessage());
        }
    }

    private void syncRemoteRouter() {
        synchronized (LOCK) {
            List<RouterDTO> routers = routerFeign.list();
            if (CollectionUtils.isEmpty(routers)) {
                if (!CollectionUtils.isEmpty(routerIds)) {
                    for (Long routerId : routerIds) {
                        routeDefinitionWriter.delete(Mono.just(String.valueOf(routerId))).subscribe();
                    }
                    routerIds = null;
                }
            } else if (CollectionUtils.isEmpty(routerIds)) {
                Set<Long> newRouterIds = new HashSet<>(routers.size());
                for (RouterDTO router : routers) {
                    routeDefinitionWriter
                        .save(Mono.just(transform2rd(router)))
                        .doOnSuccess(ret -> newRouterIds.add(router.getId()))
                        .subscribe();
                }
                routerIds = newRouterIds;
            } else {
                Set<Long> newRouterIds = new HashSet<>(routers.size());
                for (RouterDTO router : routers) {
                    routerIds.remove(router.getId());
                    routeDefinitionWriter
                        .save(Mono.just(transform2rd(router)))
                        .doOnSuccess(ret -> newRouterIds.add(router.getId()))
                        .subscribe();
                }
                if (!CollectionUtils.isEmpty(routerIds)) {
                    routerIds.forEach(id -> routeDefinitionWriter.delete(Mono.just(String.valueOf(id))).subscribe());
                }
                routerIds = newRouterIds;
            }
        }
        // 发布事件
        applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
    }

    private RouteDefinition transform2rd(RouterDTO router) {
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

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("初始化路由信息.");
        syncRouter();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
