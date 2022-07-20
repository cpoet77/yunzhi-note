package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.domain.model.LoginLog;
import cn.cpoet.yunzhi.note.domain.service.ILoginLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author CPoet
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl implements LoginLogService {
    private final ILoginLogService iLoginLogService;

    @Override
    public void log(LoginLog loginLog) {
        iLoginLogService.log(loginLog);
    }
}
