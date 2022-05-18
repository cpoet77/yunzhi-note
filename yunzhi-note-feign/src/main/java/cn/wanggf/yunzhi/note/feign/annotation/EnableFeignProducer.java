package cn.wanggf.yunzhi.note.feign.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启Feign服务
 *
 * @author wanggf
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(FeignProducersRegistrar.class)
public @interface EnableFeignProducer {
}
