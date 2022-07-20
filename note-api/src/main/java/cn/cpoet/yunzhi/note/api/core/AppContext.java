package cn.cpoet.yunzhi.note.api.core;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.constant.WebAppType;
import org.springframework.context.ApplicationContext;

/**
 * 应用上下文
 *
 * @author CPoet
 */
public interface AppContext {
    /**
     * 获取应用信息
     *
     * @return 应用信息
     */
    AppInfo appInfo();

    /**
     * 获取当前链路信息
     *
     * @return 链路信息
     */
    TraceInfo getTraceInfo();

    /**
     * 获取当前链路信息
     *
     * @param request 请求包装
     * @return 租户信息
     */
    TraceInfo getTraceInfo(RequestWrapper request);

    /**
     * 获取认证上下文
     *
     * @return 认证上下文
     */
    AuthContext authContext();

    /**
     * 获取当前应用的类型
     *
     * @return 应用类型
     */
    WebAppType getAppType();

    /**
     * 获取全局请求包装器
     *
     * @return 全局请求包装器
     */
    RequestWrapper getRequestWrapper();

    /**
     * 获取Spring应用上下文
     *
     * @return Spring应用上下文
     */
    ApplicationContext getApplicationContext();

    <T> T getBean(Class<T> clazz);
}
