package cn.wanggf.yunzhi.note.auth.interceptor;

import cn.wanggf.yunzhi.note.auth.configuration.auto.AuthPermissionMatchProperties;
import cn.wanggf.yunzhi.note.auth.configuration.auto.AuthenticateProperties;
import cn.wanggf.yunzhi.note.auth.constant.LogicEnum;
import cn.wanggf.yunzhi.note.auth.core.AuthContext;
import cn.wanggf.yunzhi.note.auth.core.Subject;
import cn.wanggf.yunzhi.note.auth.exception.AuthCheckException;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 认证权限拦截器
 *
 * @author wanggf
 */
@RequiredArgsConstructor
public class AuthenticateInterceptor implements HandlerInterceptor {
    private final AuthContext authContext;
    private final AuthenticateProperties authenticateProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        checkAccess(request);
        return true;
    }

    private void checkAccess(HttpServletRequest request) {
        Subject subject = authContext.getSubject();
        if (subject.logged()) {
            if (!CollectionUtils.isEmpty(authenticateProperties.getAuthPermissionMatch())) {
                String path = request.getServletPath();
                Map<String, AuthPermissionMatchProperties> permissionMatch = authenticateProperties.getAuthPermissionMatch();
                for (Map.Entry<String, AuthPermissionMatchProperties> entry : permissionMatch.entrySet()) {
                    if (matchPath(entry.getKey(), path)) {
                        checkAuthPermission(subject, entry.getValue());
                    }
                }
            }
        } else {
            throw new AuthCheckException("用户未登录，拒绝访问.");
        }
    }

    private void checkAuthPermission(Subject subject, AuthPermissionMatchProperties permissionMatchProperties) {
        if (permissionMatchProperties != null) {
            LogicEnum logic = permissionMatchProperties.getLogic();
            List<String> roles = permissionMatchProperties.getRoles();
            if (!CollectionUtils.isEmpty(roles) && !subject.hasRole(logic, roles.toArray(new String[0]))) {
                throw new AuthCheckException("访问权限不足.");
            }
            List<String> permissions = permissionMatchProperties.getPermissions();
            if (!CollectionUtils.isEmpty(permissions) && !subject.hasPermission(logic, permissions.toArray(new String[0]))) {
                throw new AuthCheckException("访问权限不足.");
            }
        }
    }

    private boolean matchPath(String match, String path) {
        return match != null && path != null && path.matches(match);
    }
}
