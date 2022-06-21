package cn.cpoet.yunzhi.note.comm.feign;

import cn.cpoet.yunzhi.note.api.constant.ModuleConst;
import cn.cpoet.yunzhi.note.api.core.IdGenerator;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Id生成器
 *
 * @author CPoet
 */
@FeignClient(value = ModuleConst.WEB_COMM, contextId = "IdGeneratorFeign")
public interface IdGeneratorFeign extends IdGenerator<Long> {
    /**
     * 获取生成器的名称
     *
     * @return 生成器名称
     */
    @Override
    @RequestMapping(value = "/id-generator/getName", method = RequestMethod.GET)
    String getName();

    /**
     * 获取有效ID
     *
     * @return 有效ID
     */
    @Override
    @RequestMapping(value = "/id-generator/next", method = RequestMethod.GET)
    Long next();
}
