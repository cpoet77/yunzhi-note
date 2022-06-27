package cn.cpoet.yunzhi.note.comm.component;

import cn.cpoet.yunzhi.note.api.exception.ReqsException;
import cn.cpoet.yunzhi.note.comm.constant.CommReqsStatus;
import cn.cpoet.yunzhi.note.comm.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理
 *
 * @author CPoet
 */
@Slf4j
@ControllerAdvice
public class WebErrorAdvice {
    /**
     * 请求异常处理
     */
    @ExceptionHandler(ReqsException.class)
    @ResponseBody
    public ResultVO reqsException(ReqsException e) {
        if (log.isDebugEnabled()) {
            log.debug("系统请求异常: {}, 返回状态: {}", e.getMessage(), e.getStatus(), e);
        } else {
            log.info("系统请求异常: {}, 返回状态: {}", e.getMessage(), e.getStatus());
        }
        return ResultVO.of(e.getStatus());
    }

    /**
     * 全局异常/未知异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultVO exception(Exception e) {
        log.warn("系统异常：{}", e.getMessage(), e);
        return ResultVO.of(CommReqsStatus.SYS_ERROR);
    }
}
