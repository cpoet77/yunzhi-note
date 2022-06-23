package cn.cpoet.yunzhi.note.domain.constant;

import cn.cpoet.yunzhi.note.api.exception.EnumUndefinedException;
import cn.cpoet.yunzhi.note.api.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonValue;
import io.ebean.annotation.DbEnumValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 常用状态
 *
 * @author CPoet
 */
@Getter
@RequiredArgsConstructor
public enum CommStatus {
    /**
     * 禁用状态
     */
    DISABLED(0, "禁用"),

    /**
     * 启用状态
     */
    ENABLED(1, "启用"),

    /**
     * 锁定状态
     */
    LOCKED(2, "锁定");

    @Getter(onMethod_ = {@DbEnumValue, @JsonValue})
    private final int code;

    private final String name;

    public static CommStatus ofCode(int code) {
        return EnumUtil.valueSafeOf(values(), CommStatus::getCode, code)
            .orElseThrow(() -> EnumUndefinedException.DEFAULT);
    }
}
