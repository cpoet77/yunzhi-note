package cn.cpoet.yunzhi.note.web.wsocket;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author CPoet
 */
@SpringBootApplication
public class WSocketApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(WSocketApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
