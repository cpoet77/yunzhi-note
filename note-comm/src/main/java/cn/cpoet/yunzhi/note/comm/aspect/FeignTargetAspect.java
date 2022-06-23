package cn.cpoet.yunzhi.note.comm.aspect;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.comm.annotation.FeignTarget;
import cn.cpoet.yunzhi.note.comm.exception.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Feign调用拦截
 *
 * @author CPoet
 */
@Slf4j
@Aspect
public class FeignTargetAspect {
    @Autowired
    private AuthContext authContext;

    @Before("@annotation(target)")
    public void before(FeignTarget target) {
        if (!authContext.isFeignCalled()) {
            throw new FeignException("该接口仅能通过Feign调用");
        }
    }
}
