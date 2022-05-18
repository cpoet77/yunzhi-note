package cn.wanggf.yunzhi.note.comm.domain;

import io.ebean.annotation.SoftDelete;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import java.time.LocalDateTime;

/**
 * 用户
 *
 * @author wanggf
 */
@Data
@Entity
public class Member {
    @Column
    private Long id;

    private String name;

    private String password;

    private String salt;

    @Version
    private Long version;

    @SoftDelete
    private Boolean deleted;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
