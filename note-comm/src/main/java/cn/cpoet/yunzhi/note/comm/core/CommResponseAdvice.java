package cn.cpoet.yunzhi.note.comm.core;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.comm.constant.CommStatus;
import cn.cpoet.yunzhi.note.comm.vo.ResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author CPoet
 */
@ControllerAdvice
@SuppressWarnings("all")
@RequiredArgsConstructor
public class CommResponseAdvice implements ResponseBodyAdvice<Object> {
    private final AuthContext authContext;

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果是Feign调用则不进行数据包装
        return !authContext.isFeignCalled() && !returnType.getParameterType().isAssignableFrom(ResultVO.class);
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        return body == null ? ResultVO.EMPTY_OK : ResultVO.of(CommStatus.SUCCESS, body);
    }
}
