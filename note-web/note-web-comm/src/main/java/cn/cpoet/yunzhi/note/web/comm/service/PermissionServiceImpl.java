package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.model.query.QPermission;
import cn.cpoet.yunzhi.note.domain.model.query.QRolePermission;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
