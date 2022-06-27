package cn.cpoet.yunzhi.note.comm.configuration;

import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
import cn.cpoet.yunzhi.note.api.util.SecretUtil;
import cn.cpoet.yunzhi.note.comm.aspect.FeignTargetAspect;
import cn.cpoet.yunzhi.note.comm.configuration.auto.SecretProperties;
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

import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Duration;

/**
 * @author CPoet
 */
@ComponentScan("cn.cpoet.yunzhi.note.comm.component")
@EnableFeignClients("cn.cpoet.yunzhi.note.comm.feign")
@Import({CommFeignConfig.class, OpenApiConfig.class, CommReactiveConfig.class, CommServletConfig.class})
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
    public SystemKeyHolder systemKeyHolder(SecretProperties secretProperties) throws GeneralSecurityException {
        PrivateKey privateKey = SecretUtil.decodePrivateKey(secretProperties.getPrivateKey());
        PublicKey publicKey = SecretUtil.decodePublicKey(secretProperties.getPublicKey());
        SecretKey secretKey = SecretUtil.decodeSecretKey(secretProperties.getSecretKey());
        return new SystemKeyHolderImpl(new KeyPair(publicKey, privateKey), secretKey);
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
    public FeignTargetAspect feignTargetAspect() {
        return new FeignTargetAspect();
    }

    @Bean
    @ConditionalOnMissingBean
    public SimpleUUIDGenerator simpleUuidGenerator() {
        return new SimpleUUIDGenerator();
    }
}
