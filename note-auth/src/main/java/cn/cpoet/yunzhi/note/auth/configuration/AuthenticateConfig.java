package cn.cpoet.yunzhi.note.auth.configuration;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
import cn.cpoet.yunzhi.note.auth.configuration.auto.AuthTokenProperties;
import cn.cpoet.yunzhi.note.auth.configuration.auto.AuthenticateProperties;
import cn.cpoet.yunzhi.note.auth.core.SimpleAuthContext;
import cn.cpoet.yunzhi.note.comm.configuration.auto.FeignProperties;
import cn.cpoet.yunzhi.note.comm.feign.MemberFeign;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 认证配置
 *
 * @author CPoet
 */
@Slf4j
@RequiredArgsConstructor
@Import({AuthenticateReactiveConfig.class, AuthenticateServletConfig.class})
public class AuthenticateConfig {
    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "note.auth")
    public AuthenticateProperties authenticateProperties() {
        return new AuthenticateProperties();
    }

    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "note.auth.token")
    public AuthTokenProperties authTokenProperties() {
        return new AuthTokenProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthContext authContext() {
        return new SimpleAuthContext();
    }
}
