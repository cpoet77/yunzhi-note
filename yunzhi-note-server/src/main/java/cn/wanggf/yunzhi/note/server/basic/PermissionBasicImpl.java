package cn.wanggf.yunzhi.note.server.basic;

import cn.wanggf.yunzhi.note.comm.basic.PermissionBasic;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanggf
 */
@RestController
public class PermissionBasicImpl implements PermissionBasic {
    @Override
    public Boolean hasPermission(Long uid, String name) {
        return Boolean.FALSE;
    }
}
