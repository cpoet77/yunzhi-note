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
    String CLAIMS_USER_ID = "&uid";
    /**
     * 账号
     */
    String CLAIMS_USER_ACCOUNT = "&account";
    /**
     * 请求UA
     */
    String CLAIMS_USER_AGENT = "&userAgent";
    /**
     * ip地址
     */
    String CLAIMS_IP_ADDRESS = "&ipAddress";
}
