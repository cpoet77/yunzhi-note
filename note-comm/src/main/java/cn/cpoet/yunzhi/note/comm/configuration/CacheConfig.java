package cn.cpoet.yunzhi.note.comm.configuration;

import cn.cpoet.yunzhi.note.comm.cache.StandardKeyGenerator;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;

/**
 * 缓存配置
 *
 * @author CPoet
 */
public class CacheConfig extends CachingConfigurerSupport {
    @Override
    public KeyGenerator keyGenerator() {
        return new StandardKeyGenerator();
    }
}
