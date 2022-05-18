package cn.wanggf.yunzhi.note.db.common;

import io.ebean.config.IdGenerator;

/**
 * id生成器包装
 *
 * @author wanggf
 * @see cn.wanggf.yunzhi.note.comm.common.IdGenerator
 * @see IdGenerator
 */
public class IdGeneratorWrapper implements IdGenerator {
    private final cn.wanggf.yunzhi.note.comm.common.IdGenerator<?> thisIdGenerator;

    public IdGeneratorWrapper(cn.wanggf.yunzhi.note.comm.common.IdGenerator<?> thisIdGenerator) {
        this.thisIdGenerator = thisIdGenerator;
    }

    @Override
    public String getName() {
        return thisIdGenerator.getName();
    }

    @Override
    public Object nextValue() {
        return thisIdGenerator.next();
    }
}
