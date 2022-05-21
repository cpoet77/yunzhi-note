package cn.wanggf.yunzhi.note.auth.core;

import java.util.List;
import java.util.Map;

/**
 * 认证管理
 *
 * @author wanggf
 */
public interface AuthContext {
    /**
     * 获取当前操作主体
     *
     * @return 当前主体
     */
    Subject getSubject();

    /**
     * 刷新主体信息
     *
     * @return 刷新后的主体信息
     */
    Subject refreshSubject();

    /**
     * 刷新主体信息
     *
     * @param uid     uid
     * @param account 账号
     * @return 刷新后的主体信息
     */
    Subject refreshSubject(Long uid, String account);

    /**
     * 刷新主体信息
     *
     * @param uid     uid
     * @param account 账号
     * @param claims  附加信息
     * @return 刷新后的主体信息
     */
    Subject refreshSubject(Long uid, String account, Map<String, Object> claims);

    /**
     * 添加权限验证器
     *
     * @param validator 权限验证器
     * @return 认证上下文
     */
    AuthContext addValidator(Validator validator);

    /**
     * 是否存在指定类型的权限验证链
     *
     * @param name 验证器名称
     * @return bool
     */
    boolean hasValidatorChain(String name);

    /**
     * 获取指定类型的权限验证链
     *
     * @param name 验证器名称
     * @return 权限验证链
     */
    ValidatorChain getValidatorChain(String name);

    /**
     * 获取所有权限验证链
     *
     * @return 权限验证链
     */
    List<ValidatorChain> getAllValidatorChain();
}
