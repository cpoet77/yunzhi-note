package cn.wanggf.yunzhi.note.auth.aspect;

import cn.wanggf.donkey.blog.comm.auth.Subject;
import cn.wanggf.yunzhi.note.auth.annotion.Authenticated;
import cn.wanggf.yunzhi.note.auth.context.Subject;
import cn.wanggf.yunzhi.note.auth.exception.AuthCheckException;
import cn.wanggf.yunzhi.note.auth.exception.NotAuthSubjectException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 认证
 *
 * @author wanggf
 */
@Aspect
@Component
@RequiredArgsConstructor
public class AuthenticatedAspect {
    private final Subject subject;

    @Before("@annotation(authenticated)")
    public void before(Authenticated authenticated) {
        if (authenticated.required()) {
            checkAuth(authenticated);
        }
    }

    private void checkAuth(Authenticated authenticated) {
        if (authenticated.logged()) {
            if (!subject.logged()) {
                throw new NotAuthSubjectException("用户未登录，禁止访问.");
            }
        } else if (subject.logged()) {
            throw new AuthCheckException("用户已登录，禁止访问.");
        }
    }
}
