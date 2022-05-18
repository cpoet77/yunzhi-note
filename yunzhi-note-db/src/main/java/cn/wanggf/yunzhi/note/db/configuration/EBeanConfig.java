package cn.wanggf.yunzhi.note.db.configuration;

import cn.wanggf.yunzhi.note.comm.common.IdGenerator;
import cn.wanggf.yunzhi.note.db.common.IdGeneratorWrapper;
import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ebean相关配置
 *
 * @author wanggf
 */
@Configuration
@RequiredArgsConstructor
public class EBeanConfig {
    @Bean
    @ConditionalOnMissingBean
    public DataSourceConfig dataSourceConfig(DataSourceProperties dataSourceProperties) {
        DataSourceConfig config = new DataSourceConfig();
        config.setDriver(dataSourceProperties.getDriverClassName());
        config.setUrl(dataSourceProperties.getUrl());
        config.setUsername(dataSourceProperties.getUsername());
        config.setPassword(dataSourceProperties.getPassword());
        return config;
    }

    @Bean
    @ConditionalOnMissingBean
    public DatabaseConfig databaseConfig(DataSourceConfig dataSourceConfig,
                                         List<IdGenerator<?>> idGenerators) {
        DatabaseConfig config = new DatabaseConfig();
        config.setDataSourceConfig(dataSourceConfig);
        if (!CollectionUtils.isEmpty(idGenerators)) {
            config.setIdGenerators(idGenerators
                .stream()
                .map(IdGeneratorWrapper::new)
                .collect(Collectors.toList()));
        }
        return config;
    }

    @Bean
    @ConditionalOnMissingBean
    public Database customDatabase(DatabaseConfig databaseConfig) {
        return DatabaseFactory.create(databaseConfig);
    }
}
