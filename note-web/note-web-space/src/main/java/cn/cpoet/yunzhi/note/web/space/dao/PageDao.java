package cn.cpoet.yunzhi.note.web.space.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.web.space.domain.Page;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class PageDao extends BaseDao<Page> {
    protected PageDao(Database server) {
        super(Page.class, server);
    }
}
