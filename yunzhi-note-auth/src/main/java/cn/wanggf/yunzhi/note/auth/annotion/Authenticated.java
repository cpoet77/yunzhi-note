package cn.wanggf.yunzhi.note.auth.annotion;

import java.lang.annotation.*;

/**
 * 已认证
 *
 * @author wanggf
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authenticated {
    /**
     * 是否已登录
     *
     * @return 是否已登录
     */
    boolean logged() default true;
}
