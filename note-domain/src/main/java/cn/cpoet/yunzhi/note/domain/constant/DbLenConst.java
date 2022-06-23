package cn.cpoet.yunzhi.note.domain.constant;

/**
 * 常用字段长度定义
 *
 * @author CPoet
 */
public interface DbLenConst {
    /**
     * 姓名
     */
    int STAFF_NAME = 30;

    /**
     * 账号
     */
    int ACCOUNT = 50;

    /**
     * 手机号
     */
    int MOBILE = 42;

    /**
     * 电话
     */
    int TELEPHONE = 38;

    /**
     * 邮箱
     */
    int EMAIL = 99;

    /**
     * url地址
     */
    int URL = 512;

    /**
     * 头像地址
     */
    int AVATAR = URL;

    /**
     * IP地址
     */
    int IP = 128;
}
