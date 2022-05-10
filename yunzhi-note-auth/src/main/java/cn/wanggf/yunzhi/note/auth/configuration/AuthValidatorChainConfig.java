package cn.wanggf.yunzhi.note.auth.configuration;

import cn.wanggf.donkey.blog.comm.auth.AuthContext;
import cn.wanggf.donkey.blog.comm.auth.Validator;

import java.util.List;

/**
 * 身份验证配置
 *
 * @author wanggf
 */
public class AuthValidatorChainConfig {
    private final AuthContext authContext;

    public AuthValidatorChainConfig(AuthContext authContext, List<Validator> validators) {
        this.authContext = authContext;
        registerRoleValidator(validators);
    }

    /**
     * 注册验证器
     *
     * @param validators 验证器列表
     */
    public void registerRoleValidator(List<Validator> validators) {
        validators.forEach(authContext::addValidator);
    }
}
