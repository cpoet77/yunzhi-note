package cn.wanggf.yunzhi.note.comm.constant;

/**
 * 程序状态
 *
 * @author wanggf
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
