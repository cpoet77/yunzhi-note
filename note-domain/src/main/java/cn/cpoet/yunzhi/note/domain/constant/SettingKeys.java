package cn.cpoet.yunzhi.note.domain.constant;

/**
 * 常用配置名称
 * <p>约定：系统相关配置名称以'_'为前缀，个人配置以'@'为前缀.</p>
 *
 * @author CPoet
 */
public interface SettingKeys {
    /**
     * 系统站点标题
     */
    String SITE_TITLE = "_siteTitle";

    /**
     * 系统站点副标题
     */
    String SITE_SUBTITLE = "_siteSubtitle";

    /**
     * 公共密钥
     */
    String COMMON_SECRET = "_commonSecret";

    /**
     * 登录认证信息加密开关
     */
    String LOGIN_INFO_ENCRYPT = "_loginInfoEncrypt";

    /**
     * 个人密钥
     */
    String PERSON_SECRET = "@personSecret";
}
