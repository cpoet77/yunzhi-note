package cn.cpoet.yunzhi.note.comm.cache;

import cn.cpoet.yunzhi.note.comm.constant.ElExpEnum;

import java.lang.annotation.*;

/**
 * 缓存Key
 *
 * @author CPoet
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheKey {
    /**
     * 表达式
     *
     * @return 表达式
     */
    String value();

    /**
     * 使用的El表达式
     *
     * @return El表达式
     */
    ElExpEnum elExp() default ElExpEnum.SIMPLE;
}
