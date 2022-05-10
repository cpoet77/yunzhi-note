package cn.wanggf.yunzhi.note.auth.context;

import cn.wanggf.yunzhi.note.auth.constant.LogicEnum;

import java.util.Date;
import java.util.Map;

/**
 * 当前操作主体
 *
 * @author wanggf
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
     * 判断当前主体是否已经登录
     *
     * @return 是否已经登录
     */
    boolean logged();

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

    /**
     * 获取当前主体的token
     *
     * @return token
     */
    String getToken();

    /**
     * 获取当前主体的失效时间
     *
     * @return 主体失效时间
     */
    Date getExpiration();

    /**
     * 获取当前主体的jwt信息
     *
     * @return jwt信息
     */
    Map<String, Object> getClaims();
}
