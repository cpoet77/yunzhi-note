package cn.cpoet.yunzhi.note.web.comm.controller;

import cn.cpoet.yunzhi.note.comm.annotation.FeignTarget;
import cn.cpoet.yunzhi.note.comm.feign.MemberFeign;
import cn.cpoet.yunzhi.note.web.comm.service.PermissionService;
import cn.cpoet.yunzhi.note.web.comm.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author CPoet
 */
@Primary
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Tag(name = "用户信息")
public class MemberController implements MemberFeign {
    private final RoleService roleService;
    private final PermissionService permissionService;

    @Override
    @FeignTarget
    @Operation(summary = "获取用户有效角色code")
    public Set<String> listRole(Long uid) {
        return roleService.listCodeByUid(uid);
    }

    @Override
    @FeignTarget
    @Operation(summary = "获取用户有效权限code")
    public Set<String> listPermission(Long uid) {
        return permissionService.listCodeByUid(uid);
    }
}
