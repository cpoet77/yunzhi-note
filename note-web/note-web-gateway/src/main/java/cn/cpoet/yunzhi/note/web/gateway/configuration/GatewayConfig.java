package cn.cpoet.yunzhi.note.web.gateway.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author CPoet
 */
@Slf4j
@Configuration
@EnableFeignClients("cn.cpoet.yunzhi.note.web.gateway.feign")
public class GatewayConfig {
}
