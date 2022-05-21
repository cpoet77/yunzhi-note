package cn.wanggf.yunzhi.note.auth.core;

/**
 * 权限验证器
 *
 * @author wanggf
 */
public interface PermissionValidator extends Validator {
    String NAME = PermissionValidator.class.getName();

    @Override
    default String getName() {
        return NAME;
    }
}
