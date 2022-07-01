package cn.cpoet.yunzhi.note.api.util;

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
     * 获取链路跨度id
     *
     * @return 链路跨度id
     */
    public static int getSpanId() {
        return thisApp.getTraceInfo().getSpanId();
    }

    /**
     * 获取链路跟踪id
     *
     * @return 获取链路跟踪id
     */
    public static String getTraceId() {
        return thisApp.getTraceInfo().getTraceId();
    }
}
