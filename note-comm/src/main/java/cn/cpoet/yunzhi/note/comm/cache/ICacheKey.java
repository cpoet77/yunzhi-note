package cn.cpoet.yunzhi.note.comm.cache;

/**
 * 缓存Key生成
 *
 * @author CPoet
 */
public interface ICacheKey {
    /**
     * 获取缓存Key
     *
     * @return 缓存Key
     */
    String key();
}
