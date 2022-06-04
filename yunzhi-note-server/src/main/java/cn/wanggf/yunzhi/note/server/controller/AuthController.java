package cn.wanggf.yunzhi.note.server.controller;

import cn.wanggf.yunzhi.note.server.vo.AuthVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanggf
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "auth", description = "用户认证")
public class AuthController {
    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "获取授权凭证(Token)")
    public AuthVO login() {
        return null;
    }
}
