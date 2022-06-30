package cn.cpoet.yunzhi.note.auth.core;

import cn.cpoet.yunzhi.note.api.auth.AuthReactiveContext;
import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import reactor.core.publisher.Mono;

/**
 * @author CPoet
 */
public class DefaultAuthReactiveContext extends DefaultAuthContext implements AuthReactiveContext {
    @Override
    public Mono<Subject> getSubject(Mono<RequestWrapper> request) {
        return request.map(this::getSubject);
    }

    @Override
    public Mono<Boolean> isFeignCalled(Mono<RequestWrapper> request) {
        return request.map(this::isFeignCalled);
    }
}
