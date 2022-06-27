package cn.cpoet.yunzhi.note.web.gateway.component;

import cn.cpoet.yunzhi.note.web.gateway.service.RouterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时同步路由
 *
 * @author CPoet
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SyncRouterTask {
    private final RouterService routerService;

    @Scheduled(cron = "0 0/15 * * * ?")
    public void run() {
        log.info("同步远程路由");
        routerService.syncRouter();
    }
}
