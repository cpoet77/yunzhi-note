package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.DictItem;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class DictItemBusiness extends BaseBusiness<DictItem> {
    protected DictItemBusiness(Database server) {
        super(DictItem.class, server);
    }
}
