package cn.cpoet.yunzhi.note.comm.component;

import cn.cpoet.yunzhi.note.comm.constant.ElExpEnum;

/**
 * 实体属性解析器
 *
 * @author wanggf
 */
public interface ElExpResolver {
    /**
     * 获取属性
     *
     * @param target 实体
     * @param exp    表达式
     * @return 获取结果
     */
    Object parse(Object target, String exp);

    /**
     * 解析器名称
     *
     * @return 名称
     */
    ElExpEnum getType();
}
