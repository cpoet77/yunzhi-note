package cn.cpoet.yunzhi.note.domain.constant;

import cn.cpoet.yunzhi.note.api.exception.EnumUndefinedException;
import cn.cpoet.yunzhi.note.api.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.ebean.annotation.DbEnumValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 目录项类型
 *
 * @author CPoet
 */
@Getter
@RequiredArgsConstructor
public enum CatalogItemType {
    /**
     * 笔记
     */
    NOTE("note", "笔记"),

    /**
     * 文件
     */
    FILE("file", "文件"),

    /**
     * 待办清单
     */
    TODO("todo", "待办"),

    /**
     * 预留
     */
    UNKNOWN("unknown", "未知");

    @Getter(onMethod_ = {@JsonValue, @DbEnumValue})
    private final String code;
    private final String desc;

    @JsonCreator
    public static CatalogItemType ofCode(String code) {
        return EnumUtil.valueSafeOf(values(), CatalogItemType::getCode, code)
            .orElseThrow(() -> EnumUndefinedException.DEFAULT);
    }
}
