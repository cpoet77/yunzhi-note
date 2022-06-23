package cn.cpoet.yunzhi.note.web.gateway.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author CPoet
 */
@Data
public class RouterDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 路由断言
     */
    private List<String> predicates;

    /**
     * 过滤
     */
    private List<String> filters;

    /**
     * URL
     */
    private String uri;

    /**
     * 元数据
     */
    private Map<String, Object> metadata;

    /**
     * 路由排序
     */
    private Integer sorted;
}
