package cn.cpoet.yunzhi.note.web.comm.controller;

import cn.cpoet.yunzhi.note.web.comm.dto.AccountPassDTO;
import cn.cpoet.yunzhi.note.web.comm.service.AuthService;
import cn.cpoet.yunzhi.note.web.comm.vo.AuthTokenVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CPoet
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "统一身份认证", description = "用户身份认证")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "账号密码登录")
    public AuthTokenVO login(@RequestBody @Validated AccountPassDTO accountPass) {
        return authService.login(accountPass.getAccount(), accountPass.getPassword());
    }
}
