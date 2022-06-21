package cn.cpoet.yunzhi.note.api.auth;

/**
 * 认证上下文
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
