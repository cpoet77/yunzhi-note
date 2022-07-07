package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.model.Permission;
import cn.cpoet.yunzhi.note.domain.model.query.QPermission;
import cn.cpoet.yunzhi.note.domain.model.query.QRolePermission;
import cn.cpoet.yunzhi.note.web.comm.vo.PermissionTreeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author CPoet
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final RoleService roleService;

    @Override
    public Set<String> listCodeByUid(Long uid) {
        Set<Long> roleIds = roleService.listIdByUid(uid);
        if (CollectionUtils.isEmpty(roleIds)) {
            return Collections.emptySet();
        }
        List<Long> permissionIds = new QRolePermission()
            .select(QRolePermission.alias().permissionId)
            .roleId.in(roleIds)
            .asDto(Long.class)
            .findList();
        if (CollectionUtils.isEmpty(permissionIds)) {
            return Collections.emptySet();
        }
        List<String> codes = new QPermission()
            .select(QPermission.alias().code)
            .id.in(permissionIds)
            .status.eq(CommStatus.ENABLED)
            .asDto(String.class)
            .findList();
        return CollectionUtils.isEmpty(codes) ? Collections.emptySet() : new HashSet<>(codes);
    }

    @Override
    public List<PermissionTreeVO> listPermission(Subject subject) {
        Set<Long> roleIds = roleService.listIdByUid(subject.getUid());
        if (CollectionUtils.isEmpty(roleIds)) {
            return Collections.emptyList();
        }
        List<Long> permissionIds = new QRolePermission()
            .select(QRolePermission.alias().permissionId)
            .roleId.in(roleIds)
            .asDto(Long.class)
            .findList();
        if (CollectionUtils.isEmpty(permissionIds)) {
            return Collections.emptyList();
        }
        List<Permission> permissions = new QPermission()
            .id.in(permissionIds)
            .status.eq(CommStatus.ENABLED)
            .sorted.asc()
            .findList();
        return CollectionUtils.isEmpty(permissions) ? Collections.emptyList() : generateTree(permissions);
    }

    /**
     * 生成权限树形
     *
     * @param permissions 权限列表
     * @return 权限树形
     */
    private List<PermissionTreeVO> generateTree(List<Permission> permissions) {
        List<PermissionTreeVO> items = permissions
            .stream()
            .map(PermissionTreeVO::transformOf)
            .collect(Collectors.toList());
        Map<Long, List<PermissionTreeVO>> childMap = new HashMap<>(permissions.size());
        items.forEach(item -> childMap.computeIfAbsent(item.getParentId(), k -> new ArrayList<>()).add(item));
        items.forEach(item -> item.setChildren(childMap.getOrDefault(item.getId(), Collections.emptyList())));
        return childMap.getOrDefault(SystemConst.DEFAULT_PARENT_ID, Collections.emptyList());
    }
}
