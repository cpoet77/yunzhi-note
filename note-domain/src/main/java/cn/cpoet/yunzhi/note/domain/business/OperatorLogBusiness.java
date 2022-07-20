package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.OperatorLog;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class OperatorLogBusiness extends BaseBusiness<OperatorLog> {
    protected OperatorLogBusiness(Database server) {
        super(OperatorLog.class, server);
    }
}
