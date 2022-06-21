package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_member")
public class Member extends BaseModel {
    private String name;

    private String account;

    private String password;

    private String salt;
}
