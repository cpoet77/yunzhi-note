package cn.cpoet.yunzhi.note.comm.filter;

import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.api.core.AppContext;
import cn.cpoet.yunzhi.note.api.core.TraceInfo;
import cn.cpoet.yunzhi.note.comm.core.ServletRequestWrapper;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AppContext appContext;

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 获取链路信息并存储至MDC中
        TraceInfo traceInfo = appContext.getTraceInfo(ServletRequestWrapper.wrapper((HttpServletRequest) request));
        MDC.put(SystemConst.SPAN_ID, String.valueOf(traceInfo.getSpanId()));
        MDC.put(SystemConst.TRACE_ID, traceInfo.getTraceId());
        chain.doFilter(request, response);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
