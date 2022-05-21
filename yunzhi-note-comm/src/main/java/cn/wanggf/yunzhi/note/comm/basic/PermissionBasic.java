package cn.wanggf.yunzhi.note.comm.basic;

import cn.wanggf.yunzhi.note.comm.constant.ServerConst;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wanggf
 */
@FeignClient(value = ServerConst.SERVER_SERVER, contextId = "PermissionBasic")
public interface PermissionBasic {
    /**
     * 判断用户是否具有权限
     *
     * @param uid  用户id
     * @param name 权限名称
     * @return bool
     */
    @RequestMapping(value = "cn.wanggf.yunzhi.note.comm.basic.PermissionBasic.hasPermission", method = RequestMethod.GET)
    Boolean hasPermission(@RequestParam Long uid, @RequestParam String name);
}
