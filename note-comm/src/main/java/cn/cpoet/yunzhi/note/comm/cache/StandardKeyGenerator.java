package cn.cpoet.yunzhi.note.comm.cache;

import cn.cpoet.yunzhi.note.comm.util.DigestUtil;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * 自定义缓存Key生成器
 *
 * @author CPoet
 */
public class StandardKeyGenerator implements KeyGenerator {
    /**
     * null值替换符
     */
    public final static String NULL_VALUE = "*";
    /**
     * Key分隔符
     */
    public final static String KEY_DELIMITER = ":";
    /**
     * 业务类后缀
     */
    public final static String BUS_SUFFIX_REGEX = "(Service)|(ServiceImpl)|(Dao)|(DaoImpl)$";

    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder sb = new StringBuilder()
            .append(getTargetName(target))
            .append(getTargetNameMd5(target))
            .append(KEY_DELIMITER)
            .append(method.getName());
        if (params.length > 0) {
            for (Object param : params) {
                sb
                    .append(KEY_DELIMITER)
                    .append(param == null ? NULL_VALUE : param);
            }
        }
        return sb.toString();
    }

    private String getTargetName(Object target) {
        return target.getClass().getSimpleName().replaceAll(BUS_SUFFIX_REGEX, "");
    }

    private String getTargetNameMd5(Object target) {
        return DigestUtil.md5hex(target.getClass().getName());
    }
}
