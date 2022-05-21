package cn.wanggf.yunzhi.note.auth.core;

/**
 * 角色验证器
 *
 * @author wanggf
 */
public interface RoleValidator extends Validator {
    String NAME = RoleValidator.class.getName();

    @Override
    default String getName() {
        return NAME;
    }
}
