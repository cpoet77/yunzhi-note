package cn.wanggf.yunzhi.note.server.configuration;

import cn.wanggf.yunzhi.note.comm.constant.ServerConst;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wanggf
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        Info info = new Info()
            .title("yunzhi-note-server api")
            .description("云知笔记Server模块API文档")
            .version("v1.0.0");
        return new OpenAPI().info(info);
    }


    @Bean
    public GroupedOpenApi serverApi() {
        return GroupedOpenApi
            .builder()
            .group(ServerConst.SERVER_SERVER)
            .packagesToScan("cn.wanggf.yunzhi.note.server.controller")
            .addOpenApiMethodFilter(method -> method.isAnnotationPresent(Operation.class))
            .build();
    }
}
