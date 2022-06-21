package cn.cpoet.yunzhi.note.auth.annotion;

import cn.cpoet.yunzhi.note.api.constant.SubjectType;

import java.lang.annotation.*;

/**
 * 认证
 *
 * @author CPoet
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authenticated {
    /**
     * 可以访问的主体类型
     *
     * @return 主体类型
     */
    SubjectType[] subjects() default SubjectType.STAFF;
}
