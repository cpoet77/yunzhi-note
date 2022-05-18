package cn.wanggf.yunzhi.note.comm.common;


/**
 * id生成器
 *
 * @author wanggf
 */
public interface IdGenerator<T> {
    /**
     * 获取该id生成器名称
     *
     * @return id生成器名称
     */
    String getName();

    /**
     * 生成Id
     *
     * @return 支持类型的id
     */
    T next();
}
