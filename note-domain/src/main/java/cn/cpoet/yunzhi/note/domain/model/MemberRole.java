package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseRecordModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_member_role")
public class MemberRole extends BaseRecordModel {
    /**
     * 用户id
     */
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    /**
     * 角色id
     */
    @Column(name = "role_id", nullable = false)
    private Long roleId;
}
