package cn.cpoet.yunzhi.note.domain.base;

import io.ebean.BeanRepository;
import io.ebean.Database;

/**
 * @author CPoet
 */
public abstract class BaseBusiness<T> extends BeanRepository<Long, T> {
    protected BaseBusiness(Class<T> type, Database server) {
        super(type, server);
    }
}
