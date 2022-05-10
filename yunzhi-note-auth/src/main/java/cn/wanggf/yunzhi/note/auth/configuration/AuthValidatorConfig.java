package cn.wanggf.yunzhi.note.auth.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;

/**
 * 默认实现基于角色和资源的验证
 *
 * @author wanggf
 */
@AutoConfigureBefore(AuthValidatorChainConfig.class)
@SuppressWarnings("unchecked")
@RequiredArgsConstructor
public class AuthValidatorConfig {
    private final static String ROLE_CACHE_NAME = "&userHashRoleCache";
    private final static String PERMISSION_CACHE_NAME = "&userHashPermissionCache";

//    private final IRoleService iRoleService;
//    private final IPermissionService iPermissionService;
//
//    @Bean("roleValidator")
//    public Validator roleValidator() {
//        return new Validator() {
//            @Override
//            public boolean has(Subject subject, String name) {
//                Map<String, Boolean> cache = (Map<String, Boolean>) subject.getClaims()
//                    .computeIfAbsent(ROLE_CACHE_NAME, k -> Collections.synchronizedMap(new HashMap<>(5, 1F)));
//                Boolean hasRole = cache.get(name);
//                if (hasRole == null) {
//                    hasRole = iRoleService.hasRole(subject.getUid(), name);
//                    cache.put(name, hasRole);
//                }
//                return Boolean.TRUE.equals(hasRole);
//            }
//
//            @Override
//            public ValidatorType getType() {
//                return ValidatorTypes.ROLE;
//            }
//        };
//    }
//
//    @Bean("permissionValidator")
//    public Validator permissionValidator() {
//        return new Validator() {
//            @Override
//            public boolean has(Subject subject, String name) {
//                Map<String, Boolean> cache = (Map<String, Boolean>) subject.getClaims()
//                    .computeIfAbsent(PERMISSION_CACHE_NAME, k -> Collections.synchronizedMap(new HashMap<>(5, 1F)));
//                Boolean hasPermission = cache.get(name);
//                if (hasPermission == null) {
//                    hasPermission = iPermissionService.hasPermission(subject.getUid(), name);
//                    cache.put(name, hasPermission);
//                }
//                return Boolean.TRUE.equals(hasPermission);
//            }
//
//            @Override
//            public ValidatorType getType() {
//                return ValidatorTypes.PERMISSION;
//            }
//        };
//    }
}
