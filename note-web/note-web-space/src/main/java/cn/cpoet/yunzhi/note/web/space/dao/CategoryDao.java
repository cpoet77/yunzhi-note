package cn.cpoet.yunzhi.note.web.space.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.web.space.domain.Category;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class CategoryDao extends BaseDao<Category> {
    protected CategoryDao(Database server) {
        super(Category.class, server);
    }
}
