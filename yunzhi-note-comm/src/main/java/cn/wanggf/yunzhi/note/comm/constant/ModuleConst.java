package cn.wanggf.yunzhi.note.comm.constant;

/**
 * 模块名称（服务名称）
 *
 * @author wanggf
 */
public interface ModuleConst {
    /**
     * 模块名称前缀
     */
    String MODULE_PREFIX = "yunzhi-note-";

    /*------------------------- 项目所有模块名称 -------------------------*/

    /**
     * 认证模块
     */
    String MODULE_AUTH = MODULE_PREFIX + "auth";

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
     * Feign定制模块
     */
    String MODULE_FEIGN = MODULE_PREFIX + "feign";

    /**
     * 编辑模块
     */
    String MODULE_EDITOR = MODULE_PREFIX + "editor";

    /**
     * 文件模块
     */
    String MODULE_FILE = MODULE_PREFIX + "file";

    /**
     * 网关
     */
    String MODULE_GATEWAY = MODULE_PREFIX + "gateway";

    /**
     * 插件定义
     */
    String MODULE_PLUGIN = MODULE_PREFIX + "plugin";

    /**
     * 后台主服务
     */
    String MODULE_SERVER = MODULE_PREFIX + "server";

    /**
     * 服务支撑模块
     */
    String MODULE_SERVICE = MODULE_PREFIX + "service";

    /**
     * 个人空间
     */
    String MODULE_SPACE = MODULE_PREFIX + "space";

    /*------------------------- 所有服务名称 -------------------------*/
    /**
     * 网关服务
     */
    String SERVER_GATEWAY = MODULE_GATEWAY;

    /**
     * 服务支撑
     */
    String SERVER_SERVICE = MODULE_SERVICE;
}
