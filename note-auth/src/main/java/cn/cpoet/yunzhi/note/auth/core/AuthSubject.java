package cn.cpoet.yunzhi.note.auth.core;

import cn.cpoet.yunzhi.note.api.constant.LogicEnum;
import cn.cpoet.yunzhi.note.api.constant.SubjectType;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * 认证用户主体
 *
 * @author CPoet
 */
@Setter(AccessLevel.PACKAGE)
public class AuthSubject extends GuestSubject {
    /**
     * 用户id
     */
    private long uid;

    /**
     * 用户组id
     */
    private long groupId;

    /**
     * 账号
     */
    private String account;

    AuthSubject() {
    }

    @Override
    public long getUid() {
        return uid;
    }

    @Override
    public SubjectType getType() {
        return SubjectType.STAFF;
    }

    @Override
    public long getGroupId() {
        return groupId;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public boolean hasRole(String... roles) {
        return hasRole(LogicEnum.AND, roles);
    }

    @Override
    public boolean hasRole(LogicEnum logic, String... roles) {
        return isContainVal(getRoles(), roles, logic);
    }

    @Override
    public boolean hasPermission(String... permissions) {
        return hasPermission(LogicEnum.AND, permissions);
    }

    @Override
    public boolean hasPermission(LogicEnum logic, String... permissions) {
        return isContainVal(getPermissions(), permissions, logic);
    }

    private boolean isContainVal(Collection<String> targets, String[] values, LogicEnum logic) {
        if (!CollectionUtils.isEmpty(targets) && values.length != 0) {
            if (values.length == 1) {
                return targets.contains(values[0]);
            }
            if (LogicEnum.OR.equals(logic)) {
                for (String value : values) {
                    if (targets.contains(value)) {
                        return true;
                    }
                }
            } else {
                for (String value : values) {
                    if (!targets.contains(value)) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
