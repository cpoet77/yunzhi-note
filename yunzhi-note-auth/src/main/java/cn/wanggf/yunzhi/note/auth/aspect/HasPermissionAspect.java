package cn.wanggf.yunzhi.note.auth.aspect;

import cn.wanggf.yunzhi.note.auth.annotion.HasPermission;
import cn.wanggf.yunzhi.note.auth.constant.LogicEnum;
import cn.wanggf.yunzhi.note.auth.context.Subject;
import cn.wanggf.yunzhi.note.auth.exception.PermissionCheckException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 权限验证
 *
 * @author wanggf
 */
@Aspect
@Component
@RequiredArgsConstructor
public class HasPermissionAspect {
    private final Subject subject;

    @Before("@annotation(hasPermission)")
    public void before(HasPermission hasPermission) {
        checkPermission(hasPermission);
    }

    private void checkPermission(HasPermission hasPermission) {
        if (!subject.hasPermission(hasPermission.logic(), hasPermission.value())) {
            if (LogicEnum.AND.equals(hasPermission.logic())) {
                throw new PermissionCheckException("权限不足，该访问需要同时具有" + Arrays.toString(hasPermission.value()) + "权限.");
            }
            throw new PermissionCheckException("权限不足，该访问需要具有" + Arrays.toString(hasPermission.value()) + "中任意权限.");
        }
    }
}
