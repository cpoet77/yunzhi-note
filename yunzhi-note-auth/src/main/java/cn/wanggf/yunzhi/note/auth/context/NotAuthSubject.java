package cn.wanggf.yunzhi.note.auth.context;

import cn.wanggf.yunzhi.note.auth.exception.NotAuthSubjectException;
import cn.wanggf.donkey.blog.comm.auth.AuthContext;

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
        throw new NotAuthSubjectException("用户未登录，获取uid失败.");
    }

    @Override
    public String getAccount() {
        throw new NotAuthSubjectException("用户未登录，获取用户名失败.");
    }

    @Override
    public boolean logged() {
        return false;
    }
}
