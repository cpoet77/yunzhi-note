package cn.cpoet.yunzhi.note.domain.configuration;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.constant.CipherAlgorithms;
import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.api.core.IdGenerator;
import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
import cn.cpoet.yunzhi.note.api.util.SecretUtil;
import cn.cpoet.yunzhi.note.domain.common.IdGeneratorWrapper;
import cn.cpoet.yunzhi.note.domain.configuration.auto.DataSourceProperties;
import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;

import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ebean相关配置
 *
 * @author CPoet
 */
@Slf4j
@SuppressWarnings("all")
@RequiredArgsConstructor
public class EbeanConfig {
    @Bean
    @RefreshScope
    @ConditionalOnMissingBean
    public DataSourceConfig dataSourceConfig(DataSourceProperties dataSourceProperties,
                                             ObjectProvider<SystemKeyHolder> systemKeyHolders) throws GeneralSecurityException {
        DataSourceConfig config = new DataSourceConfig();
        config.setDriver(dataSourceProperties.getDriverClassName());
        config.setUrl(dataSourceProperties.getUrl());
        if (CipherAlgorithms.NONE.equals(dataSourceProperties.getAlgorithm())) {
            config.setUsername(dataSourceProperties.getUsername());
            config.setPassword(dataSourceProperties.getPassword());
        } else {
            SystemKeyHolder systemKeyHolder = systemKeyHolders.getIfAvailable();
            if (CipherAlgorithms.RSA.equals(dataSourceProperties.getAlgorithm())) {
                PrivateKey privateKey = systemKeyHolder.getPrivateKey();
                config.setUsername(new String(SecretUtil.decrypt4base64(privateKey, dataSourceProperties.getUsername())));
                config.setPassword(new String(SecretUtil.decrypt4base64(privateKey, dataSourceProperties.getPassword())));
            } else {
                SecretKey secretKey = systemKeyHolder.getSecretKey();
                config.setUsername(new String(SecretUtil.decrypt4base64(secretKey, dataSourceProperties.getUsername())));
                config.setPassword(new String(SecretUtil.decrypt4base64(secretKey, dataSourceProperties.getPassword())));
            }
        }
        return config;
    }

    @Bean
    @RefreshScope
    @ConditionalOnMissingBean
    public Database ebeanDatabase(DataSourceConfig dataSourceConfig,
                                  ObjectProvider<AuthContext> authContexts,
                                  List<IdGenerator<?>> idGenerators) {
        DatabaseConfig config = new DatabaseConfig();
        config.setDataSourceConfig(dataSourceConfig);
        try {
            AuthContext authContext = authContexts.getIfAvailable();
            config.setCurrentUserProvider(authContext.getSubject()::getUid);
        } catch (BeansException e) {
            config.setCurrentUserProvider(() -> SystemConst.SYS_ID);
            log.warn("Auth Context is not loaded!");
        }
        if (!CollectionUtils.isEmpty(idGenerators)) {
            config.setIdGenerators(idGenerators
                .stream()
                .map(IdGeneratorWrapper::new)
                .collect(Collectors.toList()));
        }
        return DatabaseFactory.create(config);
    }
}
