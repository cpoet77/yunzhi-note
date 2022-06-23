package cn.cpoet.yunzhi.note.web.comm.controller;

import cn.cpoet.yunzhi.note.comm.annotation.FeignTarget;
import cn.cpoet.yunzhi.note.comm.core.SnowFlakeIdGenerator;
import cn.cpoet.yunzhi.note.comm.feign.IdGeneratorFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Id生成器
 *
 * @author CPoet
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/id-generator")
public class IdGeneratorController implements IdGeneratorFeign {
    private final SnowFlakeIdGenerator idGenerator;

    @Override
    @FeignTarget
    public String getName() {
        return idGenerator.getName();
    }

    @Override
    @FeignTarget
    public Long nextId() {
        return idGenerator.nextId();
    }
}
