package cn.wanggf.yunzhi.note.auth.constant;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * jwt签名算法策略
 *
 * @author wanggf
 */
@Getter
@RequiredArgsConstructor
public enum JwtSignAlgorithms {
    /**
     * 非对称算法
     */
    RS256(SignatureAlgorithm.RS256),
    /**
     * 对称算法
     */
    HS256(SignatureAlgorithm.HS256);

    /**
     * @see SignatureAlgorithm
     */
    private final SignatureAlgorithm algorithm;
}
