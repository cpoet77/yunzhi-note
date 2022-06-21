package cn.cpoet.yunzhi.note.auth.core;

/**
 * 认证管理
 *
 * @author CPoet
 */
public interface AuthContext {
    /**
     * 获取当前操作主体
     *
     * @return 当前主体
     */
    Subject getSubject();
}
