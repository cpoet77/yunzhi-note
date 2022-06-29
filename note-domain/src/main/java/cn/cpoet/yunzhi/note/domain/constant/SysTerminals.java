package cn.cpoet.yunzhi.note.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 系统终端定义
 *
 * @author CPoet
 */
@Getter
@RequiredArgsConstructor
public enum SysTerminals {
    ;
    /**
     * 终端编码
     */
    private final int code;

    /**
     * 终端名称
     */
    private final String name;
}
