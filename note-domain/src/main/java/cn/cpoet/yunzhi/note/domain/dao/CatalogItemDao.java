package cn.cpoet.yunzhi.note.domain.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.domain.model.Catalog;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class CatalogItemDao extends BaseDao<Catalog> {
    protected CatalogItemDao(Database server) {
        super(Catalog.class, server);
    }
}
