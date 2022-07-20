package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.Router;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class RouterBusiness extends BaseBusiness<Router> {
    protected RouterBusiness(Database server) {
        super(Router.class, server);
    }
}
