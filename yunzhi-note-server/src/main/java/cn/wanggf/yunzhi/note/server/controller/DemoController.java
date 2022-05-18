package cn.wanggf.yunzhi.note.server.controller;

import cn.wanggf.yunzhi.note.comm.domain.Member;
import cn.wanggf.yunzhi.note.comm.service.FnMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo
 *
 * @author wanggf
 */
@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    private final FnMemberService fnMemberService;

    @GetMapping
    public Member getById() {
        return fnMemberService.getById(1L);
    }
}
