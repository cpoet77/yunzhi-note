package cn.cpoet.yunzhi.note.domain.configuration;

import cn.cpoet.yunzhi.note.domain.configuration.auto.DataSourceProperties;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author CPoet
 */
@ImportAutoConfiguration(EbeanConfig.class)
@ComponentScan("cn.cpoet.yunzhi.note.domain.dao")
public class DomainConfig {
    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "spring.datasource")
    @ConditionalOnMissingBean
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
}
