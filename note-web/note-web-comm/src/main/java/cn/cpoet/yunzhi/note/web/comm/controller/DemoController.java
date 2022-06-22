package cn.cpoet.yunzhi.note.web.comm.controller;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @author CPoet
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping
    public Map<String, Long> index(Subject subject) {
        System.out.println(subject);
        return Collections.singletonMap("id", subject.getUid());
    }
}
