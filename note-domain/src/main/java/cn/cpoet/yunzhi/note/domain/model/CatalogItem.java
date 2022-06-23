package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import cn.cpoet.yunzhi.note.domain.constant.CatalogItemType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_catalog_item")
public class CatalogItem extends BaseModel {
    /**
     * 目录id
     */
    @Column(name = "catalog_id", nullable = false)
    private Long catalogId;

    /**
     * 目录项id
     */
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    /**
     * 类型
     */
    @Column(name = "item_type", nullable = false)
    private CatalogItemType itemType;

    /**
     * 排序
     */
    @Column(name = "sorted", nullable = false)
    private Integer sorted;
}
