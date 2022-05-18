package cn.wanggf.yunzhi.note.gateway;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关
 *
 * @author wanggf
 */
@EnableDiscoveryClient
@SpringBootApplication
public class YunzhiGatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(YunzhiGatewayApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
