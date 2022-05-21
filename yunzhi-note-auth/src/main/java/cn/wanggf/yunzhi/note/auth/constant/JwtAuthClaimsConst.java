package cn.wanggf.yunzhi.note.auth.constant;

/**
 * jwt验证相关常量
 *
 * @author wanggf
 */
public interface JwtAuthClaimsConst {
    /**
     * 用户id
     */
    String CLAIMS_USER_ID = "cn.wanggf.yunzhi.note.auth@uid";

    /**
     * 账号
     */
    String CLAIMS_USER_ACCOUNT = "cn.wanggf.yunzhi.note.auth@account";
}
