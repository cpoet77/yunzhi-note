package cn.cpoet.yunzhi.note.web.comm.service;

import java.util.Set;

/**
 * @author CPoet
 */
public interface PermissionService {
    /**
     * 获取用户拥有的权限code
     *
     * @param uid 用户id
     * @return 权限code列表
     */
    Set<String> listCodeByUid(Long uid);
}
