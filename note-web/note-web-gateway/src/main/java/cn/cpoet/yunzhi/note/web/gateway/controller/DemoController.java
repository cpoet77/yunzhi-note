package cn.cpoet.yunzhi.note.web.gateway.controller;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

/**
 * @author CPoet
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping
    public Mono<Map<String, Long>> index(Subject subject) {
        System.out.println(subject);
        return Mono.just(Collections.singletonMap("id", subject.getUid()));
    }
}
