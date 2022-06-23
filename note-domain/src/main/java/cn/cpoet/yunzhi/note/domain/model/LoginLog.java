package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseRecordModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 登录日志
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_login_log")
public class LoginLog extends BaseRecordModel {
}
