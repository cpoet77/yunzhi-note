package cn.cpoet.yunzhi.note.comm.feign.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Set;

/**
 * @author CPoet
 * @see cn.cpoet.yunzhi.note.comm.feign.MemberFeign
 */
@Component("ReactiveMemberFeign")
public class MemberFeign {

    @Autowired
    private cn.cpoet.yunzhi.note.comm.feign.MemberFeign memberFeign;

    /**
     * @see cn.cpoet.yunzhi.note.comm.feign.MemberFeign#listRole(Long)
     */
    public Mono<Set<String>> listRole(Mono<Long> uid) {
        return uid.map(id -> memberFeign.listRole(id));
    }

    /**
     * @see cn.cpoet.yunzhi.note.comm.feign.MemberFeign#listPermission(Long)
     */
    public Mono<Set<String>> listPermission(Mono<Long> uid) {
        return uid.map(id -> memberFeign.listPermission(id));
    }
}
