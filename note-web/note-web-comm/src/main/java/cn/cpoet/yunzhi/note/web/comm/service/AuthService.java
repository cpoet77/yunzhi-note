package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.domain.model.Member;
import cn.cpoet.yunzhi.note.web.comm.vo.AuthTokenVO;

/**
 * @author CPoet
 */
public interface AuthService {
    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     * @return 认证结果
     */
    AuthTokenVO login(String account, String password);

    /**
     * 签发Token
     *
     * @param member 用户
     * @return Token
     */
    AuthTokenVO signToken(Member member);

    /**
     * 校验用户状态
     *
     * @param member 用户
     */
    void checkMemberStatus(Member member);
}
