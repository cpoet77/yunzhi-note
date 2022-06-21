package cn.cpoet.yunzhi.note.api.constant;

/**
 * 系统级常量
 *
 * @author CPoet
 */
public interface SystemConst {
    /**
     * 系统ID
     */
    long SYS_ID = 0L;

    /**
     * 游客ID
     */
    long GUEST_ID = -1L;

    /**
     * 默认实体ID
     */
    long DEFAULT_ENTITY_ID = SYS_ID;

    /**
     * 默认父级ID
     */
    long DEFAULT_PARENT_ID = DEFAULT_ENTITY_ID;

    /**
     * 全局ID生成器名称
     */
    String GLOBAL_ID_GENERATOR = "yunzhi@global-id-generator";
}
