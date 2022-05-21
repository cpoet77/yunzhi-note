package cn.wanggf.yunzhi.note.auth.core;

import cn.wanggf.yunzhi.note.auth.exception.AuthException;

/**
 * 未认证主体
 *
 * @author wanggf
 */
public class NotAuthSubject extends AbstractSubject {
    public NotAuthSubject(AuthContext authContext) {
        super(authContext);
    }

    @Override
    public long getUid() {
        throw new AuthException("用户未登录，获取uid失败.");
    }

    @Override
    public String getAccount() {
        throw new AuthException("用户未登录，获取用户名失败.");
    }

    @Override
    public boolean logged() {
        return false;
    }
}
