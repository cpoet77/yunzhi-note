package cn.wanggf.yunzhi.note.comm.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 公有配置
 *
 * @author wanggf
 */
@EnableFeignClients("cn.wanggf.yunzhi.note.comm.service")
public class CommConfiguration {
}
