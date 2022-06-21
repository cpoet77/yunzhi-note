package cn.cpoet.yunzhi.note.comm.vo;

import cn.cpoet.yunzhi.note.comm.constant.Status;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 统一响应体
 *
 * @author CPoet
 */
public class ResultVO implements Map<String, Object>, Serializable {
    private static final long serialVersionUID = -2888247893297733056L;

    public final static String _CODE_KEY = "code";
    public final static String _MESSAGE_KEY = "msg";
    public final static String _TIMESTAMP_KEY = "timestamp";
    public final static String _DATA_KEY = "data";

    private final Map<String, Object> instance;

    private ResultVO() {
        instance = new HashMap<>(1 << 3, 1F);
    }

    public void setCode(Integer status) {
        instance.put(_CODE_KEY, status);
    }

    public void setMessage(String message) {
        instance.put(_MESSAGE_KEY, message);
    }

    public void setTimestamp(Long timestamp) {
        instance.put(_TIMESTAMP_KEY, timestamp);
    }

    public void setData(Object data) {
        instance.put(_DATA_KEY, data);
    }

    @Override
    public int size() {
        return instance.size();
    }

    @Override
    public boolean isEmpty() {
        return instance.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return instance.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return instance.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return instance.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        return instance.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return instance.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        instance.putAll(m);
    }

    @Override
    public void clear() {
        instance.clear();
    }

    @Override
    public Set<String> keySet() {
        return instance.keySet();
    }

    @Override
    public Collection<Object> values() {
        return instance.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return instance.entrySet();
    }

    public static ResultVO of(Status status) {
        return of(status, null);
    }

    public static ResultVO of(Status status, Object data) {
        return ofImpl(status.code(), status.message(), data);
    }

    public static ResultVO of(Status status, String message, Object data) {
        return ofImpl(status.code(), message, data);
    }

    private static ResultVO ofImpl(int status, String message, Object data) {
        ResultVO returnVo = new ResultVO();
        returnVo.setCode(status);
        returnVo.setMessage(message);
        returnVo.setData(data);
        returnVo.setTimestamp(System.currentTimeMillis());
        return returnVo;
    }
}
