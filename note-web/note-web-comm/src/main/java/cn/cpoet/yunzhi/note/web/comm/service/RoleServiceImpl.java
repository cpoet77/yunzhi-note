package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.model.MemberRole;
import cn.cpoet.yunzhi.note.domain.model.query.QMemberRole;
import cn.cpoet.yunzhi.note.domain.model.query.QRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class RoleServiceImpl implements RoleService {
    @Override
    public Set<Long> listIdByUid(Long uid) {
        List<Long> roleIds = new QMemberRole()
            .select(QMemberRole.alias().roleId)
            .memberId.eq(uid)
            .asDto(Long.class)
            .findList();
        if (CollectionUtils.isEmpty(roleIds)) {
            return Collections.emptySet();
        }
        List<Long> ids = new QRole()
            .id.in(roleIds)
            .status.eq(CommStatus.ENABLED)
            .findIds();
        return CollectionUtils.isEmpty(ids) ? Collections.emptySet() : new HashSet<>(ids);
    }

    @Override
    public Set<String> listCodeByUid(Long uid) {
        List<Long> roleIds = new QMemberRole()
            .select(QMemberRole.alias().roleId)
            .memberId.eq(uid)
            .asDto(Long.class)
            .findList();
        if (CollectionUtils.isEmpty(roleIds)) {
            return Collections.emptySet();
        }
        List<String> codes = new QRole()
            .select(QRole.alias().code)
            .id.in(roleIds)
            .status.eq(CommStatus.ENABLED)
            .asDto(String.class)
            .findList();
        return CollectionUtils.isEmpty(codes) ? Collections.emptySet() : new HashSet<>(codes);
    }
}
