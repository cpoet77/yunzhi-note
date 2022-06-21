package cn.cpoet.yunzhi.note.domain.base;

import io.ebean.annotation.WhenModified;
import io.ebean.annotation.WhoModified;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 基础模型
 *
 * @author CPoet
 */
@Data
@MappedSuperclass
public abstract class BaseModel extends BaseRecordModel {
    /**
     * 更新人员
     */
    @WhoModified
    @Column(name = "updated_member")
    private Long updatedMember;

    /**
     * 更新时间
     */
    @WhenModified
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
}
