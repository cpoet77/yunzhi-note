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

    /**
     * 请求UA
     */
    String CLAIMS_USER_AGENT = "cn.wanggf.yunzhi.note.auth@user-agent";

    /**
     * ip地址
     */
    String CLAIMS_IP_ADDRESS = "cn.wanggf.yunzhi.note.auth@ip-ddress";
}
