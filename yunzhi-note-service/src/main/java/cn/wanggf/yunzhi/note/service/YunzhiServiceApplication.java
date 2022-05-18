package cn.wanggf.yunzhi.note.service;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 服务支撑
 *
 * @author wanggf
 */
@SpringBootApplication
public class YunzhiServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(YunzhiServiceApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
