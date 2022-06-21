package cn.cpoet.yunzhi.note.domain.common;

import io.ebean.config.IdGenerator;

/**
 * id生成器包装
 *
 * @author CPoet
 * @see cn.cpoet.yunzhi.note.api.core.IdGenerator
 * @see IdGenerator
 */
public class IdGeneratorWrapper implements IdGenerator {
    private final cn.cpoet.yunzhi.note.api.core.IdGenerator<?> thisIdGenerator;

    public IdGeneratorWrapper(cn.cpoet.yunzhi.note.api.core.IdGenerator<?> thisIdGenerator) {
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
