package cn.cpoet.yunzhi.note.comm.filter;

import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import org.springframework.boot.web.servlet.filter.OrderedFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author CPoet
 */
public class ServletTraceFilter implements OrderedFilter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest resp = (HttpServletRequest) request;
        String traceId = resp.getHeader(SystemConst.TRACE_ID);
        chain.doFilter(request, response);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
