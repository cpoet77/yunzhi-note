package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.Todo;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class TodoBusiness extends BaseBusiness<Todo> {
    protected TodoBusiness(Database server) {
        super(Todo.class, server);
    }
}
