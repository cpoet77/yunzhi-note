package cn.cpoet.yunzhi.note.api.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型相关工具
 *
 * @author CPoet
 */
public class GenericsUtil {
    /**
     * 获取泛型实际类型
     *
     * @param clazz 泛型类型
     * @return 实际类型
     */
    public static Type getActualTypeArg(Class<?> clazz) {
        return ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private GenericsUtil() {
    }
}
