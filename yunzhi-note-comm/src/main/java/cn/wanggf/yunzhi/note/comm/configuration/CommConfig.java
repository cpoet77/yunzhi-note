package cn.wanggf.yunzhi.note.comm.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wanggf
 */
@EntityScan("cn.wanggf.yunzhi.note.comm.domain")
@EnableFeignClients("cn.wanggf.yunzhi.note.comm.basic")
public class CommConfig {
}
