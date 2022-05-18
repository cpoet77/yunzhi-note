package cn.wanggf.yunzhi.note.space;

import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 个人空间
 *
 * @author wanggf
 */
public class YunzhiSpaceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(YunzhiSpaceApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
