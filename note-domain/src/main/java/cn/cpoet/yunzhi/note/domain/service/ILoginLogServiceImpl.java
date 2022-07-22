package cn.cpoet.yunzhi.note.domain.service;

import cn.cpoet.yunzhi.note.api.util.AppContextUtil;
import cn.cpoet.yunzhi.note.domain.base.ServiceImpl;
import cn.cpoet.yunzhi.note.domain.model.LoginLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author CPoet
 */
@Slf4j
@Service
public class ILoginLogServiceImpl extends ServiceImpl<LoginLog> implements ILoginLogService {

    @Override
    public void log(LoginLog loginLog) {
        if (loginLog.getLoginTime() == null) {
            loginLog.setLoginTime(AppContextUtil.getReqsTime());
        }
        try {
            insert(loginLog);
        } catch (Exception e) {
            log.warn("登录日志记录失败：{}", e.getMessage(), e);
        }
    }
}
