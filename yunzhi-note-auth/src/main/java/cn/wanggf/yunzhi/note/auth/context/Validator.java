package cn.wanggf.yunzhi.note.auth.context;

/**
 * 验证器
 *
 * @author wanggf
 */
public interface Validator {
    /**
     * 验证
     *
     * @param subject 主体
     * @param name    验证名称
     * @return 是否验证成功
     */
    boolean has(Subject subject, String name);

    /**
     * 获取当前验证器的类型
     *
     * @return 验证器类型
     */
    ValidatorType getType();
}
