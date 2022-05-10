package cn.wanggf.yunzhi.note.auth.constant;

import cn.wanggf.donkey.blog.comm.auth.ValidatorType;

/**
 * 常用验证器类型定义
 *
 * @author wanggf
 */
public enum ValidatorTypes implements ValidatorType {
    /**
     * 角色验证器
     */
    ROLE,
    /**
     * 权限验证器
     */
    PERMISSION;

    @Override
    public String getName() {
        return name();
    }
}
