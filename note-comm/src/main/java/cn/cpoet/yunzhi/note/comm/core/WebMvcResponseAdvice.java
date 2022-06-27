package cn.cpoet.yunzhi.note.comm.core;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.exception.NoteException;
import cn.cpoet.yunzhi.note.comm.constant.CommReqsStatus;
import cn.cpoet.yunzhi.note.comm.vo.ResultVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
@SuppressWarnings("all")
@ControllerAdvice("cn.cpoet")
public class WebMvcResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private AuthContext authContext;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        // Feign调用的情况下不进行数据包装
        return !authContext.isFeignCalled() && !returnType.getParameterType().isAssignableFrom(ResultVO.class);
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (body == null) {
            return ResultVO.EMPTY_OK;
        }
        // 返回String类型时需要进行特殊处理
        if (body instanceof String) {
            try {
                String content = objectMapper.writeValueAsString(ResultVO.of(CommReqsStatus.SUCCESS, body));
                // 设置响应的格式为JSON
                response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                return content;
            } catch (JsonProcessingException e) {
                throw new NoteException(e);
            }
        }
        return ResultVO.of(CommReqsStatus.SUCCESS, body);
    }
}
