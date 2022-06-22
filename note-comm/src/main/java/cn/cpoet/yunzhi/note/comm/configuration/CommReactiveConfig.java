package cn.cpoet.yunzhi.note.comm.configuration;

import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import cn.cpoet.yunzhi.note.comm.core.ReactiveRequestWrapper;
import cn.cpoet.yunzhi.note.comm.filter.ReactiveWebFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

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
}
