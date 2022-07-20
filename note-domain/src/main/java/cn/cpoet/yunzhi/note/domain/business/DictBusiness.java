package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.Dict;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class DictBusiness extends BaseBusiness<Dict> {
    protected DictBusiness(Database server) {
        super(Dict.class, server);
    }
}
