package cn.wanggf.yunzhi.note.auth.aspect;

import cn.wanggf.yunzhi.note.auth.annotion.LoginLog;
import cn.wanggf.donkey.blog.comm.auth.AuthContext;
import cn.wanggf.donkey.blog.comm.auth.Subject;
import cn.wanggf.donkey.blog.comm.service.ILoginLogService;
import cn.wanggf.donkey.blog.comm.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 登录日志记录
 *
 * @author wanggf
 */
@Aspect
@Component
@RequiredArgsConstructor
public class LoginLogAspect {
    private final AuthContext authContext;
    private final HttpServletRequest request;
    private final ILoginLogService loginLogService;

    @Around("@annotation(loginLog)")
    public Object around(ProceedingJoinPoint pjp, LoginLog loginLog) throws Throwable {
        Object ret = pjp.proceed(pjp.getArgs());
        Subject subject = authContext.getSubject();
        // 判断是否登录成功
        if (subject.logged()) {
            cn.wanggf.donkey.blog.comm.domain.LoginLog log = new cn.wanggf.donkey.blog.comm.domain.LoginLog();
            log.setUid(subject.getUid());
            log.setAccount(subject.getAccount());
            log.setIpAddress(RequestUtil.findIpAddress(request));
            log.setUserAgent(RequestUtil.getUserAgent(request));
            log.setDetail(handleDetail(loginLog));
            log.setLoginModel(loginLog.model());
            log.setLoginTime(new Date());
            loginLogService.insertAsync(log);
        }
        return ret;
    }

    private String handleDetail(LoginLog loginLog) {
        return loginLog.detail();
    }
}
