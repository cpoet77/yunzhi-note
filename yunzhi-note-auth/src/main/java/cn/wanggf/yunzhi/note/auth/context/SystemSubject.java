package cn.wanggf.yunzhi.note.auth.context;

/**
 * 系统主体
 * <br />
 * 当前上下文非请求的情况下，该主体有效
 *
 * @author wanggf
 */
public class SystemSubject extends AbstractSubject {
    protected SystemSubject(AuthContext authContext) {
        super(authContext);
    }

    @Override
    public long getUid() {
        return -1;
    }

    @Override
    public String getAccount() {
        return "systemd";
    }

    @Override
    public boolean logged() {
        return false;
    }
}
