package cn.wanggf.yunzhi.note.editor;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 编辑器支持
 * <p>Socket - 长连接</p>
 *
 * @author wanggf
 */
@SpringBootApplication
public class YunzhiEditorApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(YunzhiEditorApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
