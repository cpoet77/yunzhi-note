package cn.cpoet.yunzhi.note.web.space.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.web.space.domain.Comment;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class CommentDao extends BaseDao<Comment> {
    protected CommentDao(Database server) {
        super(Comment.class, server);
    }
}
