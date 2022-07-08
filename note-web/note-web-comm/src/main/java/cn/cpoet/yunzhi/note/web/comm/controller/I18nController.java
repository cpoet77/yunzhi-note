package cn.cpoet.yunzhi.note.web.comm.controller;

import cn.cpoet.yunzhi.note.web.comm.param.I18nQueryParam;
import cn.cpoet.yunzhi.note.web.comm.service.I18nService;
import cn.cpoet.yunzhi.note.web.comm.vo.I18nMapVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 国际化
 *
 * @author CPoet
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/i18n")
@Tag(name = "I18n", description = "国标化接口")
public class I18nController {

    private final I18nService i18nService;

    @GetMapping("/listI18n")
    @Operation(summary = "获取国际化包")
    public I18nMapVO listI18n(@Validated I18nQueryParam i18nQueryParam) {
        return i18nService.listI18n(i18nQueryParam);
    }
}
