package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseRecordModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 操作日志
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_operator_log")
public class OperatorLog extends BaseRecordModel {
}
