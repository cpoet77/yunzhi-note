package cn.wanggf.yunzhi.note.auth.configuration;

import cn.wanggf.yunzhi.note.auth.core.PermissionValidator;
import cn.wanggf.yunzhi.note.auth.core.RoleValidator;
import cn.wanggf.yunzhi.note.comm.basic.PermissionBasic;
import cn.wanggf.yunzhi.note.comm.basic.RoleBasic;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认实现基于角色和资源的验证
 *
 * @author wanggf
 */
@SuppressWarnings("unchecked")
@RequiredArgsConstructor
public class AuthValidatorConfig {
    private final static String ROLE_CACHE_NAME = "cn.wanggf.yunzhi.note.auth@userHashRoleCache";
    private final static String PERMISSION_CACHE_NAME = "cn.wanggf.yunzhi.note.auth@userHashPermissionCache";

    private final ApplicationContext applicationContext;

    @Bean
    public RoleValidator roleValidator() {
        return (subject, name) -> {
            RoleBasic roleBasic = applicationContext.getBean(RoleBasic.class);
            Map<String, Boolean> cache = (Map<String, Boolean>) subject.getClaims()
                .computeIfAbsent(ROLE_CACHE_NAME, k -> Collections.synchronizedMap(new HashMap<>(5, 1F)));
            Boolean hasRole = cache.get(name);
            if (hasRole == null) {
                hasRole = roleBasic.hasRole(subject.getUid(), name);
                cache.put(name, hasRole);
            }
            return Boolean.TRUE.equals(hasRole);
        };
    }

    @Bean
    public PermissionValidator permissionValidator() {
        return (subject, name) -> {
            PermissionBasic permissionBasic = applicationContext.getBean(PermissionBasic.class);
            Map<String, Boolean> cache = (Map<String, Boolean>) subject.getClaims()
                .computeIfAbsent(PERMISSION_CACHE_NAME, k -> Collections.synchronizedMap(new HashMap<>(5, 1F)));
            Boolean hasPermission = cache.get(name);
            if (hasPermission == null) {
                hasPermission = permissionBasic.hasPermission(subject.getUid(), name);
                cache.put(name, hasPermission);
            }
            return Boolean.TRUE.equals(hasPermission);
        };
    }
}
