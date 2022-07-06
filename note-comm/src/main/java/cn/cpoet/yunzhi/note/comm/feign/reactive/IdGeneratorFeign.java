package cn.cpoet.yunzhi.note.comm.feign.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author CPoet
 * @see cn.cpoet.yunzhi.note.comm.feign.IdGeneratorFeign
 */
@Component("ReactiveIdGeneratorFeign")
public class IdGeneratorFeign {

    @Autowired
    private cn.cpoet.yunzhi.note.comm.feign.IdGeneratorFeign idGeneratorFeign;

    /**
     * @see cn.cpoet.yunzhi.note.comm.feign.IdGeneratorFeign#getName()
     */
    public Mono<String> getName() {
        return Mono.fromSupplier(idGeneratorFeign::getName);
    }

    /**
     * @see cn.cpoet.yunzhi.note.comm.feign.IdGeneratorFeign#nextId()
     */
    public Mono<Long> nextId() {
        return Mono.fromSupplier(idGeneratorFeign::nextId);
    }
}
