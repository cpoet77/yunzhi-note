package cn.cpoet.yunzhi.note.domain.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.domain.model.Catalog;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class CatalogDao extends BaseDao<Catalog> {
    protected CatalogDao(Database server) {
        super(Catalog.class, server);
    }
}
