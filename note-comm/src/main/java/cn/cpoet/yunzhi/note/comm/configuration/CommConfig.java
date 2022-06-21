package cn.cpoet.yunzhi.note.comm.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author CPoet
 */
@ComponentScan("cn.wanggf.yunzhi.note.comm.component")
@EnableFeignClients("cn.cpoet.yunzhi.note.comm.feign")
public class CommConfig {
}
