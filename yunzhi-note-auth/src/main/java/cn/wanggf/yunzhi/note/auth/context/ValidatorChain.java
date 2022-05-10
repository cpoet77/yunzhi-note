package cn.wanggf.yunzhi.note.auth.context;

import cn.wanggf.yunzhi.note.auth.constant.LogicEnum;

/**
 * 验证链
 *
 * @author wanggf
 */
public class ValidatorChain {
    private final Validator validator;
    private final ValidatorChain next;

    private ValidatorChain(Validator validator, ValidatorChain next) {
        this.validator = validator;
        this.next = next;
    }

    /**
     * 验证主体是否具有指定名称的权限验证
     *
     * @param subject 主体
     * @param logic   验证逻辑
     * @param name    名称
     * @return 是否通过
     */
    public boolean has(Subject subject, LogicEnum logic, String... name) {
        if (validator == null && next == null || name.length == 0) {
            return false;
        }
        if (validator == null) {
            return next.has(subject, logic, name);
        }
        return next == null ? aloneValidator(subject, logic, name) : jointValidator(subject, logic, name);
    }

    /**
     * 不存在下个验证节点时
     *
     * @param subject 主体
     * @param logic   验证逻辑
     * @param name    名称
     * @return 是否通过
     */
    private boolean aloneValidator(Subject subject, LogicEnum logic, String... name) {
        if (name.length == 1) {
            return validator.has(subject, name[0]);
        }
        boolean flag = LogicEnum.OR.equals(logic);
        for (String s : name) {
            if (validator.has(subject, s) == flag) {
                return flag;
            }
        }
        return true;
    }

    /**
     * 联合验证，本节点即存在验证器又存在下个验证节点时
     *
     * @param subject 验证主体
     * @param logic   验证逻辑
     * @param name    名称
     * @return 是否通过
     */
    private boolean jointValidator(Subject subject, LogicEnum logic, String... name) {
        if (name.length == 1) {
            return validator.has(subject, name[0]) || next.has(subject, logic, name);
        }
        boolean flag = LogicEnum.OR.equals(logic);
        for (String s : name) {
            if ((validator.has(subject, s) || next.has(subject, logic, name)) == flag) {
                return flag;
            }
        }
        return true;
    }

    public static ValidatorChain of(Validator validator, ValidatorChain next) {
        return new ValidatorChain(validator, next);
    }
}
