package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.LoginLog;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class LoginLogBusiness extends BaseBusiness<LoginLog> {
    protected LoginLogBusiness(Database server) {
        super(LoginLog.class, server);
    }
}
