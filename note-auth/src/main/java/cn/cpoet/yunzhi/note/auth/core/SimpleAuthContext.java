package cn.cpoet.yunzhi.note.auth.core;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.auth.Subject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证上下文
 *
 * @author CPoet
 */
@Slf4j
public class SimpleAuthContext implements AuthContext {
    /**
     * 主体信息
     */
    private final ThreadLocal<Subject> subjectTL = ThreadLocal.withInitial(this::doGetSubject);

    @Override
    public Subject getSubject() {
        return subjectTL.get();
    }

    protected Subject doGetSubject() {
        HttpServletRequest request = currentRequest();
        if (request == null) {
            return SysSubject.INSTANCE;
        }
        // 判断请求上下文中是否已经存在解析的用户信息
        Object reqsSubject = request.getAttribute("");
        if (reqsSubject instanceof Subject) {
            return (Subject) reqsSubject;
        }
        // 解析网关传递的用户信息
        return null;
    }

    protected final HttpServletRequest currentRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("获取请求上下文信息失败：{}", e.getMessage(), e);
            }
        }
        return null;
    }
}
