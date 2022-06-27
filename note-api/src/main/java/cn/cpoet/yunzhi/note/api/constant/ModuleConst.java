package cn.cpoet.yunzhi.note.api.constant;

/**
 * 模块名称
 *
 * @author CPoet
 */
public interface ModuleConst {
    /**
     * 模块名称前缀
     */
    String MODULE_PREFIX_ = SystemConst.SYSTEM_PREFIX_ + "note-";

    /**
     * WEB模块名称前缀
     */
    String MODULE_WEB_PREFIX_ = MODULE_PREFIX_ + "web-";

    /**
     * API模块
     */
    String API = MODULE_PREFIX_ + "api";

    /**
     * 认证模块
     */
    String AUTH = MODULE_PREFIX_ + "auth";

    /**
     * 公共模块
     */
    String COMMON = MODULE_PREFIX_ + "comm";

    /**
     * 领域模型持久化层
     */
    String DOMAIN = MODULE_PREFIX_ + "domain";

    /**
     * 网关
     */
    String WEB_GATEWAY = MODULE_WEB_PREFIX_ + "gateway";

    /**
     * WEB公共模块
     */
    String WEB_COMM = MODULE_WEB_PREFIX_ + "comm";

    /**
     * 后台管理模块
     */
    String WEB_ADMIN = MODULE_WEB_PREFIX_ + "admin";

    /**
     * 个人空间
     */
    String WEB_SPACE = MODULE_WEB_PREFIX_ + "space";
}
