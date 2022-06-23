package cn.cpoet.yunzhi.note.web.comm.controller;

import cn.cpoet.yunzhi.note.comm.annotation.FeignTarget;
import cn.cpoet.yunzhi.note.domain.dao.RouterDao;
import cn.cpoet.yunzhi.note.domain.model.Router;
import cn.cpoet.yunzhi.note.web.comm.service.RouterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author CPoet
 */
@RestController
@RequestMapping("/router")
@RequiredArgsConstructor
@Tag(name = "路由信息")
public class RouterController {
    private final RouterService routerService;

    @FeignTarget
    @GetMapping("/list")
    @Operation(summary = "获取有效路由列表")
    public List<Router> list() {
        return routerService.list();
    }
}
