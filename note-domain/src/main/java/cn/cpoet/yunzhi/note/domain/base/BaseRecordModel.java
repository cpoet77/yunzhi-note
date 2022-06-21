package cn.cpoet.yunzhi.note.domain.base;

import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import io.ebean.Model;
import io.ebean.annotation.SoftDelete;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhoCreated;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 记录型模型
 *
 * @author CPoet
 */
@Data
@MappedSuperclass
public abstract class BaseRecordModel extends Model {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = SystemConst.GLOBAL_ID_GENERATOR)
    private Long id;

    /**
     * 版本
     */
    @Version
    @Column(name = "version")
    private Integer version;

    /**
     * 软删除
     */
    @SoftDelete
    @Column(name = "deleted")
    private Boolean deleted;

    /**
     * 创建人
     */
    @WhoCreated
    @Column(name = "created_member")
    private Long createdMember;

    /**
     * 创建时间
     */
    @WhenCreated
    @Column(name = "created_time")
    private LocalDateTime createdTime;
}
