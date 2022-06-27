package cn.cpoet.yunzhi.note.api.constant;

/**
 * 程序状态
 *
 * @author CPoet
 */
public interface Status {
    /**
     * 统一状态码
     *
     * @return 状态码
     */
    int code();

    /**
     * 状态信息
     *
     * @return 状态信息
     */
    String message();
}
