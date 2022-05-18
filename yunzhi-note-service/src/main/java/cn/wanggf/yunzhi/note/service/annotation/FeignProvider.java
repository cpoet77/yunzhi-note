package cn.wanggf.yunzhi.note.service.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * 服务提供
 *
 * @author wanggf
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
public @interface FeignProvider {
    @AliasFor(annotation = RestController.class)
    String value() default "";
}
