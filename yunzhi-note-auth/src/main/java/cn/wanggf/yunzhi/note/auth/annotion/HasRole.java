package cn.wanggf.yunzhi.note.auth.annotion;

import cn.wanggf.yunzhi.note.auth.constant.LogicEnum;

import java.lang.annotation.*;

/**
 * 是否具有角色
 *
 * @author wanggf
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HasRole {
    String[] value();

    LogicEnum logic() default LogicEnum.OR;
}
