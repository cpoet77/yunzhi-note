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
    String MODULE_PREFIX = "note-";

    /**
     * WEB模块名称前缀
     */
    String MODULE_WEB_PREFIX = MODULE_PREFIX + "web-";

    /**
     * API模块
     */
    String API = MODULE_PREFIX + "api";

    /**
     * 认证模块
     */
    String AUTH = MODULE_PREFIX + "auth";

    /**
     * 公共模块
     */
    String COMMON = MODULE_PREFIX + "comm";

    /**
     * 领域模型持久化层
     */
    String DOMAIN = MODULE_PREFIX + "domain";

    /**
     * 网关
     */
    String WEB_GATEWAY = MODULE_WEB_PREFIX + "gateway";

    /**
     * WEB公共模块
     */
    String WEB_COMM = MODULE_WEB_PREFIX + "comm";

    /**
     * 后台管理模块
     */
    String WEB_ADMIN = MODULE_WEB_PREFIX + "admin";

    /**
     * 个人空间
     */
    String WEB_SPACE = MODULE_WEB_PREFIX + "space";
}
