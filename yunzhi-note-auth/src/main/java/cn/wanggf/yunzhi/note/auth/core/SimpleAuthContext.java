package cn.wanggf.yunzhi.note.auth.core;

import cn.wanggf.yunzhi.note.auth.configuration.auto.AuthenticateProperties;
import cn.wanggf.yunzhi.note.auth.constant.JwtAuthClaimsConst;
import cn.wanggf.yunzhi.note.auth.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.security.Key;
import java.security.KeyPair;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 简单实现认证上下文
 * <p>通过jwt对会话进行认证，如果token即将过期，将在返回头中携带即将过期标识，提示前端刷新token。</p>
 *
 * @author wanggf
 */
@Slf4j
public class SimpleAuthContext implements AuthContext {
    public final static SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.RS256;

    private final static String AUTH_SUBJECT_ATTR_NAME = "cn.wanggf.yunzhi.note.auth@authSubjectModelCache";

    private final KeyPairHold keyPairHold;
    private final Subject systemSubject;
    private final Subject notAuthSubject;
    private final Map<String, ValidatorChain> validatorChains = new ConcurrentHashMap<>();
    private final AuthenticateProperties authenticateProperties;

    public SimpleAuthContext(AuthenticateProperties authenticateProperties) {
        this.authenticateProperties = authenticateProperties;
        systemSubject = new SystemSubject(this);
        notAuthSubject = new NotAuthSubject(this);
        keyPairHold = createKeyPair();
    }

    @Override
    public Subject getSubject() {
        HttpServletRequest request = getContextRequest();
        if (request == null) {
            return systemSubject;
        }
        Object attr = request.getAttribute(AUTH_SUBJECT_ATTR_NAME);
        if (attr != null) {
            return (Subject) attr;
        }
        String token = request.getHeader(authenticateProperties.getTokenHeader());
        if (token != null) {
            try {
                Key publicKey = keyPairHold.getPublicKey();
                Claims claims = JwtUtil.decode(publicKey, token);
                Subject subject = new AuthSubject(this, token, claims);
                handleRefreshTokenFlag(subject);
                request.setAttribute(AUTH_SUBJECT_ATTR_NAME, subject);
                return subject;
            } catch (Exception e) {
                log.debug("解析jwt[token = {}]失败，原因：{}", e.getMessage(), e);
            }
        }
        return notAuthSubject;
    }

    @Override
    public Subject refreshSubject() {
        Subject subject = getSubject();
        return subject.logged() ? refreshSubject(subject.getUid(), subject.getAccount(), subject.getClaims()) : subject;
    }

    @Override
    public Subject refreshSubject(Long uid, String account) {
        return refreshSubject(uid, account, Collections.emptyMap());
    }

    @Override
    public Subject refreshSubject(Long uid, String account, Map<String, Object> claims) {
        HttpServletRequest request = getContextRequest();
        if (request == null) {
            return systemSubject;
        }
        Duration tokenDuration = authenticateProperties.getTokenDuration();
        Map<String, Object> rightClaims = new HashMap<>(claims);
        rightClaims.put(JwtAuthClaimsConst.CLAIMS_USER_ID, uid);
        rightClaims.put(JwtAuthClaimsConst.CLAIMS_USER_ACCOUNT, account);
        Key privateKey = keyPairHold.getPrivateKey();
        Key publicKey = keyPairHold.getPublicKey();
        String token = JwtUtil.encode(privateKey, String.valueOf(uid), tokenDuration.toMillis(), rightClaims, SIGNATURE_ALGORITHM);
        Subject subject = new AuthSubject(this, token, JwtUtil.decode(publicKey, token));
        request.setAttribute(AUTH_SUBJECT_ATTR_NAME, subject);
        return subject;
    }

    @Override
    public AuthContext addValidator(Validator validator) {
        String name = validator.getName();
        validatorChains.put(name, ValidatorChain.of(validator, validatorChains.get(name)));
        return this;
    }

    @Override
    public boolean hasValidatorChain(String name) {
        return getValidatorChain(name) != null;
    }

    @Override
    public ValidatorChain getValidatorChain(String name) {
        return validatorChains.get(name);
    }

    @Override
    public List<ValidatorChain> getAllValidatorChain() {
        return new ArrayList<>(validatorChains.values());
    }

    /**
     * token刷新标志
     *
     * @param subject 主体
     */
    private void handleRefreshTokenFlag(Subject subject) {
        Date expiration = subject.getExpiration();
        Duration refreshTokenBwt = authenticateProperties.getRefreshTokenBwt();
        // 判断是否需要刷新token
        if (refreshTokenBwt.toMillis() + System.currentTimeMillis() >= expiration.getTime()) {
            HttpServletResponse response = getContextResponse();
            if (response != null) {
                response.addHeader(authenticateProperties.getRefreshTokenHeader(), String.valueOf(expiration));
            }
        }
    }

    /**
     * 获取当前请求上下文中的request
     *
     * @return request
     */
    private HttpServletRequest getContextRequest() {
        RequestAttributes attr = RequestContextHolder.getRequestAttributes();
        return attr == null ? null : ((ServletRequestAttributes) attr).getRequest();
    }

    /**
     * 获取当前请求上下文中的response
     *
     * @return response
     */
    private HttpServletResponse getContextResponse() {
        RequestAttributes attr = RequestContextHolder.getRequestAttributes();
        return attr == null ? null : ((ServletRequestAttributes) attr).getResponse();
    }

    private KeyPairHold createKeyPair() {
        KeyPair keyPair = Keys.keyPairFor(SIGNATURE_ALGORITHM);
        return new KeyPairHold(keyPair.getPrivate(), keyPair.getPublic());
    }

    @Getter
    @AllArgsConstructor
    private static class KeyPairHold implements Serializable {
        private static final long serialVersionUID = 2354400766013241710L;

        private final Key privateKey;
        private final Key publicKey;
    }
}
