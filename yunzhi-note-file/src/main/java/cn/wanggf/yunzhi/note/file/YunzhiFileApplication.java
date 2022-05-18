package cn.wanggf.yunzhi.note.file;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 文件服务
 *
 * @author wanggf
 */
@SpringBootApplication
public class YunzhiFileApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(YunzhiFileApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
