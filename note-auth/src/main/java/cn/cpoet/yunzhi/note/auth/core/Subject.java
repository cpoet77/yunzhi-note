package cn.cpoet.yunzhi.note.auth.core;

import cn.cpoet.yunzhi.note.auth.constant.LogicEnum;
import cn.cpoet.yunzhi.note.auth.constant.SubjectType;

/**
 * 当前操作主体
 *
 * @author CPoet
 */
public interface Subject {
    /**
     * 获取当前主体uid
     *
     * @return uid
     */
    long getUid();

    /**
     * 获取当前主体账号
     *
     * @return 账号
     */
    String getAccount();

    /**
     * 获取当前主体的类型
     *
     * @return 主体类型
     */
    SubjectType getType();

    /**
     * 判断当前主体是否具有角色
     *
     * @param roles 角色
     * @return bool
     */
    boolean hasRole(String... roles);

    /**
     * 判断当前主体是否具有角色
     *
     * @param logic 逻辑
     * @param roles 角色
     * @return bool
     */
    boolean hasRole(LogicEnum logic, String... roles);

    /**
     * 判断当前主体是否具有权限
     *
     * @param permissions 权限
     * @return bool
     */
    boolean hasPermission(String... permissions);

    /**
     * 判断当前主体是否具有权限
     *
     * @param logic       逻辑
     * @param permissions 权限
     * @return bool
     */
    boolean hasPermission(LogicEnum logic, String... permissions);
}
