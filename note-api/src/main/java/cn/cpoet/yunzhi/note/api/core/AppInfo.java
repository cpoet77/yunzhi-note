package cn.cpoet.yunzhi.note.api.core;

import cn.cpoet.yunzhi.note.api.constant.AppInfoKeys;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * App信息
 *
 * @author CPoet
 */
public final class AppInfo {
    /**
     * 应用信息文件
     */
    private final static String APP_INFO_FILE = "app.info";

    /**
     * 应用名称
     */
    public final static String NAME;

    /**
     * 作者
     */
    public final static String AUTHOR;

    /**
     * 公司
     */
    public final static String COMPANY;

    /**
     * 邮箱
     */
    public final static String EMAIL;

    /**
     * 网站
     */
    public final static String SITE;

    /**
     * 版本
     */
    public final static Version VERSION;

    static {
        // 加载应用相关信息，默认使用Properties格式
        Properties info = new Properties();
        ClassPathResource pathResource = new ClassPathResource(APP_INFO_FILE);
        try (InputStream in = pathResource.getInputStream()) {
            info.load(in);
        } catch (IOException ignored) {
        }
        // 应用信息
        NAME = info.getProperty(AppInfoKeys.NAME);
        AUTHOR = info.getProperty(AppInfoKeys.AUTHOR);
        COMPANY = info.getProperty(AppInfoKeys.COMPANY);
        EMAIL = info.getProperty(AppInfoKeys.EMAIL);
        SITE = info.getProperty(AppInfoKeys.SITE);
        // 应用版本信息
        String major = info.getProperty(AppInfoKeys.VERSION_MAJOR);
        String minor = info.getProperty(AppInfoKeys.VERSION_MINOR);
        String revision = info.getProperty(AppInfoKeys.VERSION_REVISION);
        String build = info.getProperty(AppInfoKeys.VERSION_BUILD);
        VERSION = new Version(major == null ? 0 : Integer.parseInt(major), minor == null ? 0 : Integer.parseInt(minor),
            revision == null ? 0 : Integer.parseInt(revision), build);
    }

    private AppInfo() {
    }
}
