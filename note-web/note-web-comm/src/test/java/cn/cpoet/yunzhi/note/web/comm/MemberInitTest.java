package cn.cpoet.yunzhi.note.web.comm;

import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.dao.MemberDao;
import cn.cpoet.yunzhi.note.domain.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CPoet
 */
@SpringBootTest
public class MemberInitTest {
    @Autowired
    private MemberDao memberDao;

    @Test
    void init() {
        Member member = new Member();
        member.setName("admin");
        member.setNickName("admin");
        member.setAccount("admin");
        member.setPassword("430e4990d288baa95e2baa3223a799b9");
        member.setSalt("dec56bfb055d4f0880d1554202e1cc18");
        member.setGroupId(SystemConst.DEFAULT_ENTITY_ID);
        member.setLocked(Boolean.FALSE);
        member.setStatus(CommStatus.ENABLED);
        member.setExpiredTime(SystemConst.LOCAL_DATE_TIME_MAX);
        member.setDeleted(Boolean.FALSE);
        memberDao.insert(member);
    }
}
