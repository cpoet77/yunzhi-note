package cn.cpoet.yunzhi.note.api.util;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.core.AppContext;

import java.util.function.Supplier;

/**
 * 应用上下文工具
 *
 * @author CPoet
 */
public abstract class AppContextUtil {
    /**
     * 应用上下文
     */
    private static AppContext thisApp;

    private AppContextUtil() {
    }

    /**
     * 初始化应用上下文
     *
     * @param supplier 初始化方法
     * @return 初始化结果
     */
    public static AppContext initialize(Supplier<AppContext> supplier) {
        synchronized (AppContextUtil.class) {
            if (thisApp != null) {
                throw new IllegalStateException("App context has been initialized");
            }
            thisApp = supplier.get();
        }
        return thisApp;
    }

    /**
     * 获取应用上下文
     *
     * @return 应用上下文
     */
    public static AppContext getThisApp() {
        return thisApp;
    }

    /**
     * 获取应用上下文
     *
     * @return 应用上下文
     */
    public static AppContext appContext() {
        return getThisApp();
    }

    /**
     * 获取认证上下文
     *
     * @return 认证上下文
     */
    public static AuthContext authContext() {
        return getThisApp().authContext();
    }

    /**
     * 获取Bean
     *
     * @param clazz Bean Class
     * @param <T>   Bean类型
     * @return 存在则返回实例，不存在则返回Null
     */
    public static <T> T getBean(Class<T> clazz) {
        return getThisApp().getBean(clazz);
    }

    /**
     * 获取Bean
     *
     * @param name  指定Bean名称
     * @param clazz Bean Class
     * @param <T>   Bean类型
     * @return 存在返回实例，否则返回null
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getThisApp().getBean(name, clazz);
    }

    /**
     * 获取应用配置
     *
     * @param key 配置名
     * @return 配置值
     */
    public static String getProperty(String key) {
        return getThisApp().getProperty(key);
    }

    /**
     * 获取应用配置
     *
     * @param key          配置名
     * @param defaultValue 默认值
     * @return 配置值
     */
    public static String getProperty(String key, String defaultValue) {
        return getThisApp().getProperty(key, defaultValue);
    }

    /**
     * 获取应用配置
     *
     * @param key   配置名
     * @param clazz 类型Class
     * @param <T>   类型
     * @return 配置值
     */
    public static <T> T getProperty(String key, Class<T> clazz) {
        return getThisApp().getProperty(key, clazz);
    }

    /**
     * 获取应用配置
     *
     * @param key          配置名
     * @param clazz        类型Class
     * @param defaultValue 默认值
     * @param <T>          类型
     * @return 配置值
     */
    public <T> T getProperty(String key, Class<T> clazz, T defaultValue) {
        return getThisApp().getProperty(key, clazz, defaultValue);
    }

    /**
     * 获取链路跨度id
     *
     * @return 链路跨度id
     */
    public static int getSpanId() {
        return getThisApp().getTraceInfo().getSpanId();
    }

    /**
     * 获取链路跟踪id
     *
     * @return 获取链路跟踪id
     */
    public static String getTraceId() {
        return getThisApp().getTraceInfo().getTraceId();
    }
}
