package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import io.ebean.annotation.DbJsonB;
import io.ebean.annotation.Index;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

/**
 * 网关路由管理
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_router")
public class Router extends BaseModel {

    /**
     * 路由断言
     */
    @DbJsonB
    @Column(name = "predicates")
    private List<String> predicates;

    /**
     * 过滤
     */
    @DbJsonB
    @Column(name = "filters")
    private List<String> filters;

    /**
     * URL
     */
    @Column(name = "uri")
    private String uri;

    /**
     * 元数据
     */
    @DbJsonB
    @Column(name = "metadata")
    private Map<String, Object> metadata;

    /**
     * 路由排序
     */
    @Index
    @Column(name = "sorted", nullable = false)
    private Integer sorted;

    /**
     * 状态
     */
    @Column(name = "status", nullable = false)
    private CommStatus status;
}
