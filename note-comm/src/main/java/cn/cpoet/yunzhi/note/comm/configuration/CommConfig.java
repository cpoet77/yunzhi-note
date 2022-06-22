package cn.cpoet.yunzhi.note.comm.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @author CPoet
 */
@EnableFeignClients("cn.cpoet.yunzhi.note.comm.feign")
@Import({CommReactiveConfig.class, CommServletConfig.class})
public class CommConfig {
}
