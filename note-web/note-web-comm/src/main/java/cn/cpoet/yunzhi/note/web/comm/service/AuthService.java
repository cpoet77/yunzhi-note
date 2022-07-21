package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.domain.model.Member;
import cn.cpoet.yunzhi.note.web.comm.dto.AccountPassDTO;
import cn.cpoet.yunzhi.note.web.comm.vo.AuthTokenVO;

/**
 * @author CPoet
 */
public interface AuthService {
    /**
     * 登录
     *
     * @param accountPass 登录信息
     * @return 认证结果
     */
    AuthTokenVO login(AccountPassDTO accountPass);

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
