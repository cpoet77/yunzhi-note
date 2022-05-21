package cn.wanggf.yunzhi.note.auth.core;

import cn.wanggf.yunzhi.note.auth.constant.JwtAuthClaimsConst;
import io.jsonwebtoken.Claims;

import java.util.Date;

/**
 * 已认证主体
 *
 * @author wanggf
 */
public class AuthSubject extends AbstractSubject {
    private final long uid;
    private final String account;
    private final String token;
    private final Date expiration;

    public AuthSubject(AuthContext authContext, String token, Claims claims) {
        super(authContext);
        this.token = token;
        expiration = claims.getExpiration();
        uid = claims.get(JwtAuthClaimsConst.CLAIMS_USER_ID, Integer.class);
        account = claims.get(JwtAuthClaimsConst.CLAIMS_USER_ACCOUNT, String.class);
        getClaims().putAll(claims);
    }

    @Override
    public long getUid() {
        return uid;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public boolean logged() {
        return true;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public Date getExpiration() {
        return expiration;
    }
}
