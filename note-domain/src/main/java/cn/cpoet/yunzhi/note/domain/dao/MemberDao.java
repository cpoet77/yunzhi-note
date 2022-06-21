package cn.cpoet.yunzhi.note.domain.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.domain.model.Member;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class MemberDao extends BaseDao<Member> {
    protected MemberDao(Database server) {
        super(Member.class, server);
    }
}
