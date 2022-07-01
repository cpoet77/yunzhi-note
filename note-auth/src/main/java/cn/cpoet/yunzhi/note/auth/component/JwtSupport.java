package cn.cpoet.yunzhi.note.auth.component;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.core.AppContext;
import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
import cn.cpoet.yunzhi.note.auth.configuration.auto.AuthTokenProperties;
import cn.cpoet.yunzhi.note.auth.constant.JwtConst;
import cn.cpoet.yunzhi.note.auth.core.AuthSubjectBuilder;
import cn.cpoet.yunzhi.note.comm.feign.MemberFeign;
import cn.cpoet.yunzhi.note.comm.util.UUIDUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

/**
 * Jwt操作支持
 *
 * @author CPoet
 */
@Component
@RequiredArgsConstructor
public class JwtSupport {
    private final AppContext appContext;
    private final MemberFeign memberFeign;
    private final SystemKeyHolder systemKeyHolder;
    private final AuthTokenProperties authTokenProperties;

    private Algorithm algorithm;

    public String getToken(Subject subject) {
        final long millis = System.currentTimeMillis();
        return JWT
            .create()
            .withJWTId(UUIDUtil.random())
            .withIssuer(appContext.appInfo().name())
            .withIssuedAt(new Date(millis))
            .withExpiresAt(new Date(millis + authTokenProperties.getTokenDuration().toMillis()))
            .withSubject(String.valueOf(subject.getUid()))
            .withClaim(JwtConst.CLAIM_UID, subject.getUid())
            .withClaim(JwtConst.CLAIM_ACCOUNT, subject.getAccount())
            .withClaim(JwtConst.CLAIM_GROUP_ID, subject.getGroupId())
            .sign(getAlgorithm());
    }

    public Subject getSubject(String token) {
        DecodedJWT decoded = verify(token);
        return genAuthSubject(decoded.getClaim(JwtConst.CLAIM_UID).asLong(),
            decoded.getClaim(JwtConst.CLAIM_ACCOUNT).asString(),
            decoded.getClaim(JwtConst.CLAIM_GROUP_ID).asLong());
    }

    public DecodedJWT verify(String token) {
        return JWT
            .require(getAlgorithm())
            .build()
            .verify(token);
    }

    public Algorithm getAlgorithm() {
        if (algorithm != null) {
            return algorithm;
        }
        PublicKey publicKey = systemKeyHolder.getPublicKey();
        PrivateKey privateKey = systemKeyHolder.getPrivateKey();
        return (algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey));
    }

    public Subject genAuthSubject(Long uid, String account, Long groupId) {
        Assert.notNull(uid, "用户id不能为空");
        Assert.hasText(account, "用户账号不能为空");
        Assert.notNull(groupId, "用户组id不能为空");
        return new AuthSubjectBuilder()
            .withUid(uid)
            .withAccount(account)
            .withGroupId(groupId)
            .withGetRoles(memberFeign::listRole)
            .withGetPermissions(memberFeign::listPermission)
            .build();
    }
}
