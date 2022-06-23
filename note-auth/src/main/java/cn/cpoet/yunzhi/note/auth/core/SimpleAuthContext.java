package cn.cpoet.yunzhi.note.auth.core;

import cn.cpoet.yunzhi.note.api.auth.AuthContext;
import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import cn.cpoet.yunzhi.note.api.core.SystemKeyHolder;
import cn.cpoet.yunzhi.note.api.util.SecretUtil;
import cn.cpoet.yunzhi.note.auth.configuration.auto.AuthTokenProperties;
import cn.cpoet.yunzhi.note.auth.constant.AuthConst;
import cn.cpoet.yunzhi.note.auth.constant.JwtConst;
import cn.cpoet.yunzhi.note.comm.configuration.auto.FeignProperties;
import cn.cpoet.yunzhi.note.comm.constant.FeignConst;
import cn.cpoet.yunzhi.note.comm.core.FeignAuthBean;
import cn.cpoet.yunzhi.note.comm.feign.MemberFeign;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;
import java.util.Objects;

/**
 * 认证上下文
 *
 * @author CPoet
 */
@Slf4j
public class SimpleAuthContext implements AuthContext {
    @Autowired
    private MemberFeign memberFeign;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SystemKeyHolder systemKeyHolder;
    @Autowired
    private FeignProperties feignProperties;
    @Autowired(required = false)
    private RequestWrapper globalRequestWrapper;
    @Autowired
    private AuthTokenProperties authTokenProperties;

    private Algorithm algorithm;

    /**
     * 主体信息
     */
    private final ThreadLocal<Subject> subjectTL = ThreadLocal.withInitial(() -> null);

    @Override
    public Subject getSubject() {
        return getSubject(globalRequestWrapper);
    }

    @Override
    public Subject getSubject(RequestWrapper request) {
        Subject subject = subjectTL.get();
        if (subject != null) {
            return subject;
        }
        subject = doGetSubject(request);
        subjectTL.set(subject);
        return subject;
    }

    @Override
    public boolean isFeignCalled() {
        return isFeignCalled(globalRequestWrapper);
    }

    @Override
    public boolean isFeignCalled(RequestWrapper request) {
        String feignFlag = request.getHeader(FeignConst.FEIGN_FLAG);
        String feignClient = request.getHeader(FeignConst.FEIGN_CLIENT);
        if (!StringUtils.hasText(feignFlag) || !StringUtils.hasText(feignClient)) {
            return false;
        }
        try {
            // 解密FeignFlag
            byte[] decrypt = SecretUtil.decrypt4base64(systemKeyHolder.getPrivateKey(), feignFlag);
            FeignAuthBean feignAuthBean = objectMapper.readValue(decrypt, new TypeReference<FeignAuthBean>() {
            });
            // 调用者身份确认
            if (!Objects.equals(feignAuthBean.getClient(), feignClient)) {
                return false;
            }
            Duration intervalTime = feignProperties.getIntervalTime();
            // 验证调用的时间差
            return intervalTime.isZero() || System.currentTimeMillis() - feignAuthBean.getTimeMillis() <= intervalTime.toMillis();
        } catch (GeneralSecurityException | IOException e) {
            log.debug("验证Feign调用时数据解密失败", e);
        }
        return false;
    }

    protected Subject doGetSubject(RequestWrapper request) {
        if (request == null || !request.requesting()) {
            return SysSubject.INSTANCE;
        }
        Object reqsSubject = request.getAttribute(AuthConst.REQS_SUBJECT_CACHE);
        // 判断请求上下文中是否已经存在解析的用户信息
        if (reqsSubject instanceof Subject) {
            return (Subject) reqsSubject;
        }
        // 解析Jwt获取用户信息
        String token = request.getHeader(authTokenProperties.getTokenHeader());
        if (!StringUtils.hasText(token) && StringUtils.hasText(authTokenProperties.getTokenParam())) {
            token = request.getParameter(authTokenProperties.getTokenParam());
        }
        if (StringUtils.hasText(token)) {
            Algorithm algorithm = getAlgorithm();
            try {
                DecodedJWT decoded = JWT.require(algorithm).build().verify(token);
                Subject subject = genAuthSubject(decoded.getClaim(JwtConst.CLAIM_UID).asLong(),
                    decoded.getClaim(JwtConst.CLAIM_ACCOUNT).asString(),
                    decoded.getClaim(JwtConst.CLAIM_GROUP_ID).asLong());
                request.setAttribute(AuthConst.REQS_SUBJECT_CACHE, subject);
                return subject;
            } catch (Exception e) {
                log.debug("无效的Token[token={}]：{}", token, e.getMessage());
            }
        }
        request.setAttribute(AuthConst.REQS_SUBJECT_CACHE, GuestSubject.INSTANCE);
        return GuestSubject.INSTANCE;
    }

    protected Subject genAuthSubject(Long uid, String account, Long groupId) {
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

    protected Algorithm getAlgorithm() {
        if (algorithm != null) {
            return algorithm;
        }
        PublicKey publicKey = systemKeyHolder.getPublicKey();
        PrivateKey privateKey = systemKeyHolder.getPrivateKey();
        return (algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey));
    }
}
