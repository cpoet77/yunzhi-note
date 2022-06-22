package cn.cpoet.yunzhi.note.auth.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Import;

/**
 * @author CPoet
 */
@RequiredArgsConstructor
@Import(AuthenticateWebMvcConfig.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class AuthenticateServletConfig {

}
