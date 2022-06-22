package cn.cpoet.yunzhi.note.comm.configuration;

import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
import cn.cpoet.yunzhi.note.api.util.SecretUtil;
import cn.cpoet.yunzhi.note.comm.configuration.auto.SecretProperties;
import cn.cpoet.yunzhi.note.comm.core.SystemKeyHolderImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author CPoet
 */
@EnableFeignClients("cn.cpoet.yunzhi.note.comm.feign")
@Import({CommReactiveConfig.class, CommServletConfig.class})
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
}
