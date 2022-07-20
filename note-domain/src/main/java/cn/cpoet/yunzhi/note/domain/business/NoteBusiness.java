package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.Note;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class NoteBusiness extends BaseBusiness<Note> {
    protected NoteBusiness(Database server) {
        super(Note.class, server);
    }
}
