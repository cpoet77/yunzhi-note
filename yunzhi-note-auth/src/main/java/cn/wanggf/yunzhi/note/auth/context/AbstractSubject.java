package cn.wanggf.yunzhi.note.auth.context;

import cn.wanggf.donkey.blog.comm.auth.LogicEnum;
import cn.wanggf.yunzhi.note.auth.constant.ValidatorTypes;
import cn.wanggf.donkey.blog.comm.auth.ValidatorChain;
import cn.wanggf.donkey.blog.comm.auth.AuthContext;
import cn.wanggf.donkey.blog.comm.auth.Subject;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象主体
 *
 * @author wanggf
 */
public abstract class AbstractSubject implements Subject {
    private final AuthContext authContext;
    private final Map<String, Object> claims;

    protected AbstractSubject(AuthContext authContext) {
        this.authContext = authContext;
        this.claims = new ConcurrentHashMap<>();
    }

    @Override
    public boolean hasRole(String... roles) {
        return hasRole(LogicEnum.OR, roles);
    }

    @Override
    public boolean hasRole(LogicEnum logic, String... roles) {
        ValidatorChain validatorChain = authContext.getValidatorChain(ValidatorTypes.ROLE);
        return validatorChain != null && validatorChain.has(authContext.getSubject(), logic, roles);
    }

    @Override
    public boolean hasPermission(String... permissions) {
        return hasPermission(LogicEnum.OR, permissions);
    }

    @Override
    public boolean hasPermission(LogicEnum logic, String... permissions) {
        ValidatorChain validatorChain = authContext.getValidatorChain(ValidatorTypes.PERMISSION);
        return validatorChain != null && validatorChain.has(authContext.getSubject(), logic, permissions);
    }

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public Date getExpiration() {
        return new Date(Long.MAX_VALUE);
    }

    @Override
    public Map<String, Object> getClaims() {
        return claims;
    }
}
