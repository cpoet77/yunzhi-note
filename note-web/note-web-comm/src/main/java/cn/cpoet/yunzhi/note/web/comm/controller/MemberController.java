package cn.cpoet.yunzhi.note.web.comm.controller;

import cn.cpoet.yunzhi.note.comm.annotation.FeignTarget;
import cn.cpoet.yunzhi.note.comm.feign.MemberFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author CPoet
 */
@RestController
@RequestMapping("/member")
public class MemberController implements MemberFeign {
    @Override
    @FeignTarget
    public Set<String> listRole(Long uid) {
        return null;
    }

    @Override
    @FeignTarget
    public Set<String> listPermission(Long uid) {
        return null;
    }
}
