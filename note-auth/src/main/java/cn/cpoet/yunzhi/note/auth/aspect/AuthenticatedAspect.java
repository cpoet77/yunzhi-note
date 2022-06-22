package cn.cpoet.yunzhi.note.auth.aspect;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.auth.annotion.Authenticated;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 认证
 *
 * @author CPoet
 */
@Aspect
@RequiredArgsConstructor
public class AuthenticatedAspect {
    private final AuthContext authContext;

    @Before("@annotation(authenticated)")
    public void before(Authenticated authenticated) {
//        Subject subject = authContext.getSubject();
//        if (authenticated.logged()) {
//            if (!subject.logged()) {
//                throw new AuthCheckException("用户未登录，禁止访问.");
//            }
//        } else if (subject.logged()) {
//            throw new AuthCheckException("用户已登录，禁止访问.");
//        }
    }
}
