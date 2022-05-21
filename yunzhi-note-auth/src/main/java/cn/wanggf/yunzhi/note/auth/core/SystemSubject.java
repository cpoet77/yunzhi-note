package cn.wanggf.yunzhi.note.auth.core;

/**
 * 系统主体
 * <br />
 * 当前上下文非请求的情况下，该主体有效
 *
 * @author wanggf
 */
public class SystemSubject extends AbstractSubject {
    public final static long SYS_ID = -1L;

    public final static String SYS_ACCOUNT = "systemd";

    protected SystemSubject(AuthContext authContext) {
        super(authContext);
    }

    @Override
    public long getUid() {
        return SYS_ID;
    }

    @Override
    public String getAccount() {
        return SYS_ACCOUNT;
    }

    @Override
    public boolean logged() {
        return false;
    }
}
