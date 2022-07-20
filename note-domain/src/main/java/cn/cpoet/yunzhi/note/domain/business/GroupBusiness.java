package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.Group;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class GroupBusiness extends BaseBusiness<Group> {
    protected GroupBusiness(Database server) {
        super(Group.class, server);
    }
}
