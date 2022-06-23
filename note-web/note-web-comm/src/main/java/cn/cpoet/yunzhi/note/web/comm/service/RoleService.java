package cn.cpoet.yunzhi.note.web.comm.service;

import java.util.Set;

/**
 * @author CPoet
 */
public interface RoleService {
    /**
     * 获取用户拥有的角色id
     *
     * @param uid 用户id
     * @return 角色id列表
     */
    Set<Long> listIdByUid(Long uid);

    /**
     * 获取用户拥有的角色code
     *
     * @param uid 用户id
     * @return 角色code列表
     */
    Set<String> listCodeByUid(Long uid);
}
