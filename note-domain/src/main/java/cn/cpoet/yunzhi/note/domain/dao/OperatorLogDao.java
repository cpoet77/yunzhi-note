package cn.cpoet.yunzhi.note.domain.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.domain.model.OperatorLog;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class OperatorLogDao extends BaseDao<OperatorLog> {
    protected OperatorLogDao(Database server) {
        super(OperatorLog.class, server);
    }
}
