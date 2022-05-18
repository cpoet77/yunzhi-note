package cn.wanggf.yunzhi.note.feign.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启Feign消费
 * <p>常规FeignClient需使用{@link org.springframework.cloud.openfeign.EnableFeignClients}</p>
 *
 * @author wanggf
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(FeignConsumersRegistrar.class)
public @interface EnableFeignConsumer {
}
