package cn.cpoet.yunzhi.note.comm.feign;

import cn.cpoet.yunzhi.note.api.constant.ModuleConst;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * @author CPoet
 */
@FeignClient(value = ModuleConst.WEB_COMM, contextId = "MemberFeign", path = "/member")
public interface MemberFeign {
    /**
     * 获取角色列表
     *
     * @param uid 用户uid
     * @return 角色列表
     */
    @RequestMapping(value = "/listRole", method = RequestMethod.GET)
    Set<String> listRole(@RequestParam Long uid);

    /**
     * 获取权限列表
     *
     * @param uid 用户uid
     * @return 角色列表
     */
    @RequestMapping(value = "/listPermission", method = RequestMethod.GET)
    Set<String> listPermission(@RequestParam Long uid);
}
