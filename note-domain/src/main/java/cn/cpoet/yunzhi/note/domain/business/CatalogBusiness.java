package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.Catalog;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class CatalogBusiness extends BaseBusiness<Catalog> {
    protected CatalogBusiness(Database server) {
        super(Catalog.class, server);
    }
}
