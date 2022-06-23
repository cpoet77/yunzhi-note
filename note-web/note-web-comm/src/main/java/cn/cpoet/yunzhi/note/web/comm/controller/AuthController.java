package cn.cpoet.yunzhi.note.web.comm.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证
 *
 * @author CPoet
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "用户身份认证")
public class AuthController {
    @GetMapping
    public String demo() {
        return "Hello World";
    }
}
