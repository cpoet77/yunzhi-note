package cn.cpoet.yunzhi.note.api.core;

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
    private final static String APP_INFO_FILE = "version.properties";

    /**
     * 应用名称
     */
    public final static String NAME;

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
        Properties info = new Properties();
        ClassPathResource pathResource = new ClassPathResource(APP_INFO_FILE);
        try (InputStream in = pathResource.getInputStream()) {
            info.load(in);
        } catch (IOException ignored) {
        }
        NAME = info.getProperty("name");
        COMPANY = info.getProperty("company");
        EMAIL = info.getProperty("email");
        SITE = info.getProperty("site");
        String major = info.getProperty("version.major");
        String minor = info.getProperty("version.minor");
        String revision = info.getProperty("version.revision");
        String build = info.getProperty("version.build");
        VERSION = new Version(major == null ? 0 : Integer.parseInt(major), minor == null ? 0 : Integer.parseInt(minor),
            revision == null ? 0 : Integer.parseInt(revision), build);
    }

    private AppInfo() {
    }
}
