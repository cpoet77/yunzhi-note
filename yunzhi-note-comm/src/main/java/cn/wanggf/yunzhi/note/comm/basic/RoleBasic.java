package cn.wanggf.yunzhi.note.comm.basic;

import cn.wanggf.yunzhi.note.comm.constant.ServerConst;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wanggf
 */
@FeignClient(value = ServerConst.SERVER_SERVER, contextId = "RoleBasic")
public interface RoleBasic {
    /**
     * 判断用户是否具有角色
     *
     * @param uid      用户id
     * @param roleName 角色名
     * @return bool
     */
    @RequestMapping(value = "cn.wanggf.yunzhi.note.comm.basic.RoleBasic.hasRole", method = RequestMethod.GET)
    Boolean hasRole(@RequestParam Long uid, @RequestParam String roleName);
}
