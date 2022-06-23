package cn.cpoet.yunzhi.note.comm.component;

import cn.cpoet.yunzhi.note.comm.constant.ReqsStatus;
import cn.cpoet.yunzhi.note.comm.vo.ResultVO;
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
@ControllerAdvice
public class WebErrorAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultVO exception(Exception e) {
        return ResultVO.of(ReqsStatus.SYS_ERROR);
    }
}
