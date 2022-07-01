package cn.cpoet.yunzhi.note.api.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.WebApplicationType;

/**
 * 网络应用类型定义
 *
 * @author CPoet
 */
@Getter
@RequiredArgsConstructor
public enum WebAppType {
    /**
     * Servlet应用
     */
    SERVLET(WebApplicationType.SERVLET),

    /**
     * Reactive应用
     */
    REACTIVE(WebApplicationType.REACTIVE),

    /**
     * 非网络应用
     */
    NONE(WebApplicationType.NONE);

    /**
     * 与Spring应用的类型映射
     */
    private final WebApplicationType type;

    /**
     * 根据类型获取
     *
     * @param type Spring应用类型
     * @return 映射类型
     */
    public static WebAppType ofType(WebApplicationType type) {
        for (WebAppType value : values()) {
            if (value.type == type) {
                return value;
            }
        }
        return null;
    }
}
