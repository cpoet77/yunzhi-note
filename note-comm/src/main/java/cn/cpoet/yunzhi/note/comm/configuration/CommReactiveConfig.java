package cn.cpoet.yunzhi.note.comm.configuration;

import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import cn.cpoet.yunzhi.note.comm.core.ReactiveRequestWrapper;
import cn.cpoet.yunzhi.note.comm.filter.ReactiveWebFilter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.server.WebFilter;

import java.util.stream.Collectors;

/**
 * @author CPoet
 */
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
public class CommReactiveConfig {

    @Bean
    public WebFilter reactiveWebFilter() {
        return new ReactiveWebFilter();
    }

    @Bean
    @ConditionalOnMissingBean
    public RequestWrapper requestWrapper() {
        return ReactiveRequestWrapper.wrapper(null);
    }

    /**
     * Reactive模式下缺失问题（Feign不可用问题）
     *
     * @param converters {@link HttpMessageConverter}
     * @return {@link HttpMessageConverters}
     */
    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }
}
