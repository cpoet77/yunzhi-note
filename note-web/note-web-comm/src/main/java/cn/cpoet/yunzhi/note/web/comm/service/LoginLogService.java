package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.domain.model.LoginLog;

/**
 * @author CPoet
 */
public interface LoginLogService {
    /**
     * 记录登录日志
     *
     * @param loginLog 登录日志
     */
    void log(LoginLog loginLog);

    /**
     * 添加登录日志
     *
     * @param loginLog 登录日志
     */
    void insert(LoginLog loginLog);
}
