package cn.cpoet.yunzhi.note.domain.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.domain.model.DictItem;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class DictItemDao extends BaseDao<DictItem> {
    protected DictItemDao(Database server) {
        super(DictItem.class, server);
    }
}
