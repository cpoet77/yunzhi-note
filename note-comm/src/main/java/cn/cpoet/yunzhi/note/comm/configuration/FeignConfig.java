package cn.cpoet.yunzhi.note.comm.configuration;

import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
import cn.cpoet.yunzhi.note.comm.configuration.auto.FeignProperties;
import cn.cpoet.yunzhi.note.comm.core.FeignRequestInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

/**
 * feign全局配置
 *
 * @author CPoet
 */
public class FeignConfig {
    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "note.feign")
    public FeignProperties feignProperties() {
        return new FeignProperties();
    }

    @Bean
    public FeignRequestInterceptor feignRequestInterceptor(ObjectMapper objectMapper, SystemKeyHolder systemKeyHolder) {
        return new FeignRequestInterceptor(objectMapper, systemKeyHolder);
    }
}
