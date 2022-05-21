package cn.wanggf.yunzhi.note.comm.basic;

import cn.wanggf.yunzhi.note.comm.constant.ServerConst;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户
 *
 * @author wanggf
 */
@FeignClient(value = ServerConst.SERVER_SERVER, contextId = "UserBasic")
public interface UserBasic {
}
