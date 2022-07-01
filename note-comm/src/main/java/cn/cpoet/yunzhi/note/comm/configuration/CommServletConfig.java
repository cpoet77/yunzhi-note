package cn.cpoet.yunzhi.note.comm.configuration;

import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import cn.cpoet.yunzhi.note.comm.core.AbstractServletRequestWrapper;
import cn.cpoet.yunzhi.note.comm.core.WebMvcResponseAdvice;
import cn.cpoet.yunzhi.note.comm.filter.ServletTraceFilter;
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
    public ServletTraceFilter servletTraceFilter() {
        return new ServletTraceFilter();
    }

    @Bean
    @ConditionalOnMissingBean
    public RequestWrapper requestWrapper() {
        return new GlobalRequestWrapper();
    }

    @Bean
    @ConditionalOnMissingBean
    public WebMvcResponseAdvice commResponseAdvice() {
        return new WebMvcResponseAdvice();
    }

    /**
     * 全局请求上下文包装
     * <p>仅适用于Servlet应用</p>
     */
    private static class GlobalRequestWrapper extends AbstractServletRequestWrapper {
        @Override
        protected HttpServletRequest getRequest() {
            try {
                return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            } catch (Exception e) {
                CommServletConfig.log.debug("获取请求上下文失败：{}", e.getMessage());
            }
            return null;
        }
    }
}
