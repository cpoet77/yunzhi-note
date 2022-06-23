package cn.cpoet.yunzhi.note.comm.core;

import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
import cn.cpoet.yunzhi.note.api.util.SecretUtil;
import cn.cpoet.yunzhi.note.comm.constant.FeignConst;
import cn.cpoet.yunzhi.note.comm.exception.FeignException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/**
 * Feign全局数据加密、特征标识
 *
 * @author CPoet
 */
public class FeignRequestInterceptor implements RequestInterceptor {
    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SystemKeyHolder systemKeyHolder;

    @Override
    public void apply(RequestTemplate template) {
        FeignAuthBean feignAuthBean = new FeignAuthBean();
        feignAuthBean.setClient(applicationName);
        feignAuthBean.setTimeMillis(System.currentTimeMillis());
        // 增加约定的Feign调用标识
        try {
            String bean = objectMapper.writeValueAsString(feignAuthBean);
            template.header(FeignConst.FEIGN_FLAG, SecretUtil.encrypt2base64(systemKeyHolder.getPublicKey(),
                bean.getBytes(StandardCharsets.UTF_8)));
        } catch (JsonProcessingException | GeneralSecurityException e) {
            throw new FeignException("发起Feign调用前，设置约定标识失败.", e);
        }
        template.header(FeignConst.FEIGN_CLIENT, applicationName);
    }
}
