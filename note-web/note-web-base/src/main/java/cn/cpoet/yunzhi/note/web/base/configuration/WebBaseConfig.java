package cn.cpoet.yunzhi.note.web.base.configuration;

import org.springframework.context.annotation.ComponentScan;

/**
 * @author CPoet
 */
@ComponentScan({
    "cn.cpoet.yunzhi.note.web.base.service",
    "cn.cpoet.yunzhi.note.web.base.controller"
})
public class WebBaseConfig {
}
