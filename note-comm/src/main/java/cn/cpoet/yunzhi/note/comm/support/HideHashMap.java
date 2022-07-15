package cn.cpoet.yunzhi.note.comm.support;

import io.swagger.v3.oas.annotations.Hidden;

import java.util.HashMap;
import java.util.Map;

/**
 * 针对OpenApi做的适配
 *
 * @author CPoet
 */
public class HideHashMap<K, V> extends HashMap<K, V> implements Map<K, V> {
    @Override
    @Hidden
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
