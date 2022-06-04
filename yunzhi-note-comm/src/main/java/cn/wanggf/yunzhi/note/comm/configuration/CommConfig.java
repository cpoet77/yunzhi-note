package cn.wanggf.yunzhi.note.comm.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wanggf
 */
@ComponentScan("cn.wanggf.yunzhi.note.comm.component")
@EntityScan("cn.wanggf.yunzhi.note.comm.domain")
@EnableFeignClients("cn.wanggf.yunzhi.note.comm.basic")
public class CommConfig {
}
