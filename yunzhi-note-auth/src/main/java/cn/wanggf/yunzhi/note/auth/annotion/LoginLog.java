package cn.wanggf.yunzhi.note.auth.annotion;

import cn.wanggf.donkey.blog.comm.constant.LoginModelEnum;
import cn.wanggf.donkey.blog.comm.support.ExpressionSupport;

import java.lang.annotation.*;

/**
 * 登录日志
 *
 * @author wanggf
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginLog {
    /**
     * 登录方式
     *
     * @return 登录方式
     */
    LoginModelEnum model();

    /**
     * 登录详细说明
     *
     * @return 登录详细说明
     */
    String detail() default "";

    /**
     * 生成{@link #detail()}使用的el表达式
     *
     * @return el表达式
     */
    Class<? extends ExpressionSupport> expression() default ExpressionSupport.class;
}
