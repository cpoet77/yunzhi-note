package cn.wanggf.yunzhi.note.auth.core;

/**
 * 验证器
 *
 * @author wanggf
 */
public interface Validator {
    /**
     * 获取验证器名称
     *
     * @return 验证器名称
     */
    String getName();

    /**
     * 验证
     *
     * @param subject 主体
     * @param name    验证名称
     * @return 是否验证成功
     */
    boolean has(Subject subject, String name);
}
