package cn.cpoet.yunzhi.note.web.comm.vo;

import cn.cpoet.yunzhi.note.domain.constant.PermissionType;
import cn.cpoet.yunzhi.note.domain.model.Permission;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author CPoet
 */
@Data
@Schema(title = "权限树形信息")
public class PermissionTreeVO {
    @Schema(title = "权限id")
    private Long id;

    @Schema(title = "父权限id")
    private Long parentId;

    @Schema(title = "资源编码")
    private String code;

    @Schema(title = "资源名称")
    private String name;

    @Schema(title = "路径")
    private String path;

    @Schema(title = "图标")
    private String icon;

    @Schema(title = "绑定的i18n")
    private String bindI18n;

    @Schema(title = "排序")
    private Integer sorted;

    @Schema(title = "权限类型")
    private PermissionType type;

    @Schema(title = "子权限列表")
    private List<PermissionTreeVO> children;

    public static PermissionTreeVO transformOf(Permission permission) {
        PermissionTreeVO vo = new PermissionTreeVO();
        vo.setId(permission.getId());
        vo.setParentId(permission.getParentId());
        vo.setCode(permission.getCode());
        vo.setName(permission.getName());
        vo.setPath(permission.getPath());
        vo.setIcon(permission.getIcon());
        vo.setBindI18n(permission.getBindI18n());
        vo.setSorted(permission.getSorted());
        vo.setType(permission.getType());
        vo.setChildren(Collections.emptyList());
        return vo;
    }
}
