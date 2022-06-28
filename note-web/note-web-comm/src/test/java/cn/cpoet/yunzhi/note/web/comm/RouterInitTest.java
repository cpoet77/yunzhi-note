package cn.cpoet.yunzhi.note.web.comm;

import cn.cpoet.yunzhi.note.api.constant.ModuleConst;
import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.dao.RouterDao;
import cn.cpoet.yunzhi.note.domain.model.Router;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * @author CPoet
 */
@SpringBootTest
public class RouterInitTest {
    @Autowired
    private RouterDao routerDao;

    @Test
    void init() {
        Router router = new Router();
        router.setUri("lb://" + ModuleConst.WEB_COMM);
        router.setPredicates(Collections.singletonList("Path=/api/**"));
        router.setFilters(Collections.singletonList("RewritePath=/api/?(?<segment>.*),/$\\{segment}"));
        router.setStatus(CommStatus.ENABLED);
        router.setSorted(SystemConst.DEFAULT_SORED);
        router.setDeleted(Boolean.FALSE);
        routerDao.save(router);
    }
}
