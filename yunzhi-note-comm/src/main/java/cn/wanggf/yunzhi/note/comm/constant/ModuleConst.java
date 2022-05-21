package cn.wanggf.yunzhi.note.comm.constant;

/**
 * 模块名称
 *
 * @author wanggf
 */
public interface ModuleConst {
    /**
     * 模块名称前缀
     */
    String MODULE_PREFIX = "yunzhi-note-";

    /**
     * 认证核心模块
     */
    String MODULE_AUTH = MODULE_PREFIX + "auth-core";

    /**
     * 认证模块客户端
     */
    String MODULE_AUTH_CLIENT = MODULE_PREFIX + "auth-client";

    /**
     * 公共模块
     */
    String MODULE_COMMON = MODULE_PREFIX + "comm";

    /**
     * 持久化支撑模块
     */
    String MODULE_DB = MODULE_PREFIX + "db";

    /**
     * 网关
     */
    String MODULE_GATEWAY = MODULE_PREFIX + "gateway";

    /**
     * 插件定义
     */
    String MODULE_PLUGIN = MODULE_PREFIX + "plugin";

    /**
     * 主服务
     */
    String MODULE_SERVER = MODULE_PREFIX + "server";

    /**
     * 服务支撑模块
     */
    String MODULE_SERVICE = MODULE_PREFIX + "service";

    /**
     * 后台管理模块
     */
    String MODULE_ADMIN = MODULE_PREFIX + "admin";

    /**
     * 文件模块
     */
    String MODULE_FILE = MODULE_PREFIX + "file";

    /**
     * 编辑模块
     */
    String MODULE_EDITOR = MODULE_PREFIX + "editor";

    /**
     * 个人空间
     */
    String MODULE_SPACE = MODULE_PREFIX + "space";
}
