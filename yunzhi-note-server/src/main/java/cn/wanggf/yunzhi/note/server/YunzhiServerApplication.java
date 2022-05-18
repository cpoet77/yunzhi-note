package cn.wanggf.yunzhi.note.server;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 主服务
 *
 * @author wanggf
 */
@SpringBootApplication
public class YunzhiServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(YunzhiServerApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
