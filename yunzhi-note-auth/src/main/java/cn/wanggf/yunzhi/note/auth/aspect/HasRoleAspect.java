package cn.wanggf.yunzhi.note.auth.aspect;

import cn.wanggf.yunzhi.note.auth.annotion.HasRole;
import cn.wanggf.donkey.blog.comm.auth.LogicEnum;
import cn.wanggf.yunzhi.note.auth.exception.RoleCheckException;
import cn.wanggf.donkey.blog.comm.auth.Subject;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 角色验证
 *
 * @author wanggf
 */
@Aspect
@Component
@RequiredArgsConstructor
public class HasRoleAspect {
    private final Subject subject;

    @Before("@annotation(hasRole)")
    public void before(HasRole hasRole) {
        checkRole(hasRole);
    }

    private void checkRole(HasRole hasRole) {
        if (!subject.hasRole(hasRole.logic(), hasRole.value())) {
            if (LogicEnum.AND.equals(hasRole.logic())) {
                throw new RoleCheckException("权限不足，该访问需要同时具有" + Arrays.toString(hasRole.value()) + "角色.");
            }
            throw new RoleCheckException("权限不足，该访问需要具有" + Arrays.toString(hasRole.value()) + "中任意角色.");
        }
    }
}
