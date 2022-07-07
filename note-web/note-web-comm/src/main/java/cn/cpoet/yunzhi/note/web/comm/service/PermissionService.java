package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.web.comm.vo.PermissionTreeVO;

import java.util.List;
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

    /**
     * 获取所有权限列表
     *
     * @param subject 主体信息
     * @return 权限列表
     */
    List<PermissionTreeVO> listPermission(Subject subject);
}
