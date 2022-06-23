package cn.cpoet.yunzhi.note.web.space.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.web.space.domain.Article;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class ArticleDao extends BaseDao<Article> {
    protected ArticleDao(Database server) {
        super(Article.class, server);
    }
}
