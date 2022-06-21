package cn.cpoet.yunzhi.note.auth.core;

import cn.cpoet.yunzhi.note.api.constant.SubjectType;
import cn.cpoet.yunzhi.note.api.constant.SystemConst;

/**
 * 游客主体
 *
 * @author CPoet
 */
public class GuestSubject extends SysSubject {

    public final static GuestSubject INSTANCE = new GuestSubject();

    GuestSubject() {
    }

    @Override
    public long getUid() {
        return SystemConst.GUEST_ID;
    }

    @Override
    public SubjectType getType() {
        return SubjectType.GUEST;
    }
}
