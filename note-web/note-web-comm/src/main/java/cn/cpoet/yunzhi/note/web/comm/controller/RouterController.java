package cn.cpoet.yunzhi.note.web.comm.controller;

import cn.cpoet.yunzhi.note.comm.annotation.FeignTarget;
import cn.cpoet.yunzhi.note.domain.dao.RouterDao;
import cn.cpoet.yunzhi.note.domain.model.Router;
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
public class RouterController {
    private final RouterDao routerDao;

    @FeignTarget
    @GetMapping("/list")
    public List<Router> list() {
        return routerDao.findAll();
    }
}
