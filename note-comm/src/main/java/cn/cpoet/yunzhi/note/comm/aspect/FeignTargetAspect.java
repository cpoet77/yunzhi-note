package cn.cpoet.yunzhi.note.comm.aspect;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.comm.annotation.FeignTarget;
import cn.cpoet.yunzhi.note.comm.exception.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Feign调用拦截
 *
 * @author CPoet
 */
@Slf4j
@Aspect
@RequiredArgsConstructor
public class FeignTargetAspect {
    private final AuthContext authContext;

    @Before("@annotation(target)")
    public void before(FeignTarget target) {
        if (!authContext.isFeignCalled()) {
            throw new FeignException("该接口仅能通过Feign调用");
        }
    }
}
