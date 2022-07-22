package cn.cpoet.yunzhi.note.web.comm;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author CPoet
 */
@EnableCaching
@SpringBootApplication
public class CommApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CommApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
