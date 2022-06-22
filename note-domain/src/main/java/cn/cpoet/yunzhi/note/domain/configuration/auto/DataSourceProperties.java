package cn.cpoet.yunzhi.note.domain.configuration.auto;

import cn.cpoet.yunzhi.note.api.constant.CipherAlgorithms;
import lombok.Data;

/**
 * custom-datasource
 *
 * @author CPoet
 */
@Data
public class DataSourceProperties {
    /**
     * 用户名和密码是否已加密
     * <p>默认使用{@link CipherAlgorithms#DES}算法加密</p>
     */
    private CipherAlgorithms algorithm = CipherAlgorithms.DES;

    /**
     * 数据源名称
     */
    private String name;

    /**
     * 数据库驱动
     */
    private String driverClassName;

    /**
     * 数据库连接地址
     */
    private String url;

    /**
     * 数据库用户名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;
}
