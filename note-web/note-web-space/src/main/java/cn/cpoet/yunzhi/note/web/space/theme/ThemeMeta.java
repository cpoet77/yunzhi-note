package cn.cpoet.yunzhi.note.web.space.theme;

import lombok.Data;

/**
 * 主题元信息
 *
 * @author CPoet
 */
@Data
public class ThemeMeta {
    /**
     * 主题编码（唯一）
     */
    private String code;

    /**
     * 主题名称
     */
    private String name;

    /**
     * 主题介绍
     */
    private String description;
}
