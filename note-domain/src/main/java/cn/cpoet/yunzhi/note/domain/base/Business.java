package cn.cpoet.yunzhi.note.domain.base;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 抽象业务层
 *
 * @author CPoet
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Business {
    /**
     * 自定义bean名称
     *
     * @return bean名称
     */
    @AliasFor(annotation = Component.class)
    String value() default "";
}
