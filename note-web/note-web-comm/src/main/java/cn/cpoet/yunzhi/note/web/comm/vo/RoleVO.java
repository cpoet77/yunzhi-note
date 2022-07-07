package cn.cpoet.yunzhi.note.web.comm.vo;

import cn.cpoet.yunzhi.note.domain.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author CPoet
 */
@Data
@Schema(title = "角色信息")
public class RoleVO {
    @Schema(title = "角色id")
    private Long id;

    @Schema(title = "角色编码")
    private String code;

    @Schema(title = "角色名称")
    private String name;

    @Schema(title = "排序")
    private Integer sorted;

    @Schema(title = "绑定的I18n")
    private String bindI18n;

    public static RoleVO transformOf(Role role) {
        RoleVO vo = new RoleVO();
        vo.setId(role.getId());
        vo.setCode(role.getCode());
        vo.setName(role.getName());
        vo.setSorted(role.getSorted());
        vo.setBindI18n(role.getBindI18n());
        return vo;
    }
}
