package cn.cpoet.yunzhi.note.api.auth;

import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import reactor.core.publisher.Mono;

/**
 * 响应式编程认证上下文
 *
 * @author CPoet
 */
public interface AuthReactiveContext extends AuthContext {
    /**
     * 获取当前操作主体
     *
     * @param request 请求上下文
     * @return 当前主体
     */
    Mono<Subject> getSubject(Mono<RequestWrapper> request);

    /**
     * 判断当前请求是否由Feign发起
     *
     * @param request 请求上下文信息
     * @return bool
     */
    Mono<Boolean> isFeignCalled(Mono<RequestWrapper> request);
}
