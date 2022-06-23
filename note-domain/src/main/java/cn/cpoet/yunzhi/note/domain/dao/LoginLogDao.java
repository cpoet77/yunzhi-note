package cn.cpoet.yunzhi.note.domain.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.domain.model.LoginLog;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class LoginLogDao extends BaseDao<LoginLog> {
    protected LoginLogDao(Database server) {
        super(LoginLog.class, server);
    }
}
