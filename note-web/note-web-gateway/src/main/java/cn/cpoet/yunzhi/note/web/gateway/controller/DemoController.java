package cn.cpoet.yunzhi.note.web.gateway.controller;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.comm.feign.IdGeneratorFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author CPoet
 */
@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    private final IdGeneratorFeign idGeneratorFeign;

    @GetMapping
    public Mono<Map<String, Long>> index(Subject subject) {
        System.out.println(subject);
        return Mono
            .fromFuture(CompletableFuture.supplyAsync(idGeneratorFeign::nextId))
            .map(id -> Collections.singletonMap("id", id));
    }
}
