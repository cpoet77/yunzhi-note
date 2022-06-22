package cn.cpoet.yunzhi.note.api.auth;

import cn.cpoet.yunzhi.note.api.core.RequestWrapper;

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

    /**
     * 获取当前操作主体
     *
     * @param request 请求请求环境
     * @return 操作主体
     */
    Subject getSubject(RequestWrapper request);
}
