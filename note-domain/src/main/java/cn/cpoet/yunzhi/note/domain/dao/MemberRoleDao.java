package cn.cpoet.yunzhi.note.domain.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.domain.model.MemberRole;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class MemberRoleDao extends BaseDao<MemberRole> {
    protected MemberRoleDao(Database server) {
        super(MemberRole.class, server);
    }
}
