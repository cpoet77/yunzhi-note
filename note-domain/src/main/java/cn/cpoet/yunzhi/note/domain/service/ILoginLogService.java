package cn.cpoet.yunzhi.note.domain.service;

import cn.cpoet.yunzhi.note.domain.base.BaseService;
import cn.cpoet.yunzhi.note.domain.model.LoginLog;

/**
 * @author CPoet
 */
public interface ILoginLogService extends BaseService<LoginLog> {
    /**
     * 记录登录日志
     *
     * @param loginLog 登录日志
     */
    void log(LoginLog loginLog);
}
