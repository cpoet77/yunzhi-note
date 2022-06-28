package cn.cpoet.yunzhi.note.comm.configuration;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.api.core.AppInfo;
import cn.cpoet.yunzhi.note.comm.annotation.FeignTarget;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SpringDocUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * @author CPoet
 */
@Profile({SystemConst.APP_PROFILE_DEV, SystemConst.APP_PROFILE_TEST})
public class OpenApiConfig {
    static {
        SpringDocUtils
            .getConfig()
            .addRequestWrapperToIgnore(AuthContext.class, Subject.class);
    }

    @Bean
    @ConditionalOnMissingBean
    public OpenAPI openApiInfo() {
        return new OpenAPI()
            .info(new Info()
                .title(AppInfo.NAME)
                .version(AppInfo.VERSION.version())
                .contact(new Contact().name(AppInfo.AUTHOR).email(AppInfo.EMAIL).url(AppInfo.SITE)));
    }

    @Bean
    @ConditionalOnMissingBean(name = "openApi")
    public GroupedOpenApi openApi() {
        return GroupedOpenApi.builder()
            .group("open")
            .packagesToScan("cn.cpoet")
            .addOpenApiMethodFilter(method -> !method.isAnnotationPresent(FeignTarget.class))
            .build();
    }

    @Bean
    @ConditionalOnMissingBean(name = "feignOpenApi")
    public GroupedOpenApi feignOpenApi() {
        return GroupedOpenApi.builder()
            .group("feign")
            .packagesToScan("cn.cpoet")
            .addOpenApiMethodFilter(method -> method.isAnnotationPresent(FeignTarget.class))
            .build();
    }
}
