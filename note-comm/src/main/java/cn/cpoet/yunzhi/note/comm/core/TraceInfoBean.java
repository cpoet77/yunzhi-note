package cn.cpoet.yunzhi.note.comm.core;

import cn.cpoet.yunzhi.note.api.core.TraceInfo;
import lombok.RequiredArgsConstructor;

/**
 * 链路信息实现
 *
 * @author CPoet
 */
@RequiredArgsConstructor
public class TraceInfoBean implements TraceInfo {
    /**
     * 跨度id
     */
    private final int spanId;

    /**
     * 跟踪id
     */
    private final String traceId;

    @Override
    public int getSpanId() {
        return spanId;
    }

    @Override
    public String getTraceId() {
        return traceId;
    }
}
