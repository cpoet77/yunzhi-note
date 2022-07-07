package cn.cpoet.yunzhi.note.comm.configuration;

import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.api.core.AppContext;
import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
import cn.cpoet.yunzhi.note.api.util.AppContextUtil;
import cn.cpoet.yunzhi.note.comm.aspect.FeignTargetAspect;
import cn.cpoet.yunzhi.note.comm.configuration.auto.SecretProperties;
import cn.cpoet.yunzhi.note.comm.core.DefaultAppContext;
import cn.cpoet.yunzhi.note.comm.core.SimpleUUIDGenerator;
import cn.cpoet.yunzhi.note.comm.core.SystemKeyHolderImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

/**
 * @author CPoet
 */
@ComponentScan("cn.cpoet.yunzhi.note.comm.component")
@EnableFeignClients("cn.cpoet.yunzhi.note.comm.feign")
@Import({JacksonConvertersConfig.class, CommFeignConfig.class, OpenApiConfig.class, CommReactiveConfig.class, CommServletConfig.class})
public class CommConfig {
    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "note.secret")
    public SecretProperties secretProperties() {
        return new SecretProperties();
    }

    @Bean
    @RefreshScope
    @ConditionalOnMissingBean
    public SystemKeyHolder systemKeyHolder() {
        return new SystemKeyHolderImpl();
    }

    @Bean
    @Primary
    @RefreshScope
    @ConfigurationProperties(prefix = "spring.task.execution")
    public TaskExecutionProperties taskExecutionProperties() {
        TaskExecutionProperties properties = new TaskExecutionProperties();
        properties.setThreadNamePrefix(SystemConst.SYSTEM_PREFIX_);
        TaskExecutionProperties.Pool pool = properties.getPool();
        pool.setCoreSize(5);
        pool.setQueueCapacity(1 << 8);
        pool.setMaxSize(1 << 8);
        pool.setKeepAlive(Duration.ofSeconds(30));
        return properties;
    }

    @Bean
    @Primary
    @RefreshScope
    @ConfigurationProperties(prefix = "spring.task.scheduling")
    public TaskSchedulingProperties taskSchedulingProperties() {
        TaskSchedulingProperties taskSchedulingProperties = new TaskSchedulingProperties();
        taskSchedulingProperties.setThreadNamePrefix(SystemConst.SYSTEM_PREFIX_ + "sd-");
        return taskSchedulingProperties;
    }

    @Bean
    @Primary
    public AppContext appContext() {
        return AppContextUtil.initialize(DefaultAppContext::new);
    }

    @Bean
    public FeignTargetAspect feignTargetAspect() {
        return new FeignTargetAspect();
    }

    @Bean
    @ConditionalOnMissingBean
    public SimpleUUIDGenerator simpleUuidGenerator() {
        return SimpleUUIDGenerator.INSTANCE;
    }
}
