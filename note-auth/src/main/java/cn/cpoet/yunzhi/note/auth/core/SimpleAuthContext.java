package cn.cpoet.yunzhi.note.auth.core;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 认证上下文
 *
 * @author CPoet
 */
@Slf4j
@RequiredArgsConstructor
public class SimpleAuthContext implements AuthContext {
    private final RequestWrapper globalRequestWrapper;

    /**
     * 主体信息
     */
    private final ThreadLocal<Subject> subjectTL = ThreadLocal.withInitial(() -> null);

    @Override
    public Subject getSubject() {
        return getSubject(globalRequestWrapper);
    }

    @Override
    public Subject getSubject(RequestWrapper request) {
        Subject subject = subjectTL.get();
        if (subject != null) {
            return subject;
        }
        subject = doGetSubject(request);
        subjectTL.set(subject);
        return subject;
    }

    protected Subject doGetSubject(RequestWrapper request) {
        if (request == null || !request.requesting()) {
            return SysSubject.INSTANCE;
        }
        Object reqsSubject = globalRequestWrapper.getAttribute("");
        // 判断请求上下文中是否已经存在解析的用户信息
        if (reqsSubject instanceof Subject) {
            return (Subject) reqsSubject;
        }
        // 解析Jwt获取用户信息

        return GuestSubject.INSTANCE;
    }
}
