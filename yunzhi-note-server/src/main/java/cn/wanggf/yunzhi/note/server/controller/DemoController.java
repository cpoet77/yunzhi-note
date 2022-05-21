package cn.wanggf.yunzhi.note.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanggf
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping
    public String index() {
        return "Hello World";
    }
}
