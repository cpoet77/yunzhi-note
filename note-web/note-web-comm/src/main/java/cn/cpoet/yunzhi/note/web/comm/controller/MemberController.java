package cn.cpoet.yunzhi.note.web.comm.controller;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.comm.annotation.FeignTarget;
import cn.cpoet.yunzhi.note.comm.dto.IdQueryDTO;
import cn.cpoet.yunzhi.note.comm.feign.MemberFeign;
import cn.cpoet.yunzhi.note.web.comm.service.MemberService;
import cn.cpoet.yunzhi.note.web.comm.service.PermissionService;
import cn.cpoet.yunzhi.note.web.comm.service.RoleService;
import cn.cpoet.yunzhi.note.web.comm.vo.MemberInfoVO;
import cn.cpoet.yunzhi.note.web.comm.vo.PermissionTreeVO;
import cn.cpoet.yunzhi.note.web.comm.vo.RoleVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author CPoet
 */
@Primary
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Tag(name = "Member", description = "用户信息")
public class MemberController implements MemberFeign {
    private final RoleService roleService;
    private final MemberService memberService;
    private final PermissionService permissionService;

    @PostMapping("/getInfo")
    @Operation(summary = "获取用户基本信息")
    public MemberInfoVO getInfo(Subject subject) {
        return memberService.getInfo(subject);
    }

    @PostMapping("/listMemberRole")
    @Operation(summary = "获取用户拥有的角色列表")
    public List<RoleVO> listMemberRole(Subject subject) {
        return roleService.listRole(subject);
    }

    @PostMapping("/listMemberPermission")
    @Operation(summary = "获取用户拥有的权限列表")
    public List<PermissionTreeVO> listMemberPermission(Subject subject) {
        return permissionService.listPermission(subject);
    }

    @Override
    @FeignTarget
    @Operation(summary = "获取用户有效角色code")
    public Set<String> listRole(IdQueryDTO idQuery) {
        return roleService.listCodeByUid(idQuery.getId());
    }

    @Override
    @FeignTarget
    @Operation(summary = "获取用户有效权限code")
    public Set<String> listPermission(IdQueryDTO idQuery) {
        return permissionService.listCodeByUid(idQuery.getId());
    }
}
