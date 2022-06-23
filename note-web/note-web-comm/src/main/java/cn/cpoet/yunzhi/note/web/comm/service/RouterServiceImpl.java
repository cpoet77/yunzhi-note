package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.model.Router;
import cn.cpoet.yunzhi.note.domain.model.query.QRouter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CPoet
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RouterServiceImpl implements RouterService {

    @Override
    public List<Router> list() {
        return new QRouter()
            .status.eq(CommStatus.ENABLED)
            .findList();
    }
}
