package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.domain.dao.LoginLogDao;
import cn.cpoet.yunzhi.note.domain.model.LoginLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author CPoet
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl implements LoginLogService {
    private final LoginLogDao loginLogDao;

    @Override
    public void log(LoginLog loginLog) {
        if (loginLog.getLoginTime() == null) {
            loginLog.setLoginTime(LocalDateTime.now());
        }
        try {
            insert(loginLog);
        } catch (Exception e) {
            log.warn("登录日志记录失败：{}", e.getMessage(), e);
        }
    }

    @Override
    public void insert(LoginLog loginLog) {
        loginLogDao.insert(loginLog);
    }
}
