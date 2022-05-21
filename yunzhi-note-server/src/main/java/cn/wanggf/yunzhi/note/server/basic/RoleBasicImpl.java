package cn.wanggf.yunzhi.note.server.basic;

import cn.wanggf.yunzhi.note.comm.basic.RoleBasic;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanggf
 */
@RestController
public class RoleBasicImpl implements RoleBasic {

    @Override
    public Boolean hasRole(Long uid, String roleName) {
        return Boolean.FALSE;
    }
}
