package cn.cpoet.yunzhi.note.comm.configuration;

import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import cn.cpoet.yunzhi.note.comm.component.CommResponseAdvice;
import cn.cpoet.yunzhi.note.comm.core.AbstractServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author CPoet
 */
@Slf4j
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class CommServletConfig {
    @Bean
    @ConditionalOnMissingBean
    public RequestWrapper requestWrapper() {
        return new AbstractServletRequestWrapper() {
            @Override
            protected HttpServletRequest getRequest() {
                try {
                    return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
                } catch (Exception e) {
                    if (CommServletConfig.log.isDebugEnabled()) {
                        CommServletConfig.log.debug("获取请求上下文失败：{}", e.getMessage());
                    }
                }
                return null;
            }
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public CommResponseAdvice commResponseAdvice() {
        return new CommResponseAdvice();
    }
}
