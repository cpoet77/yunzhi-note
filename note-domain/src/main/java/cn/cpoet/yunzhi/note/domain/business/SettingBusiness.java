package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.model.Setting;
import cn.cpoet.yunzhi.note.domain.model.query.QSetting;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author CPoet
 */
@Slf4j
@Business
public class SettingBusiness extends BaseBusiness<Setting> {

    @Autowired
    private ObjectMapper objectMapper;

    protected SettingBusiness(Database server) {
        super(Setting.class, server);
    }

    /**
     * 根据名称查询配置
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置
     */
    public Setting findByName(String name, Long memberId) {
        return new QSetting()
            .name.eq(name)
            .memberId.eq(memberId)
            .status.eq(CommStatus.ENABLED)
            .findOne();
    }

    /**
     * 获取所有配置列表
     *
     * @param memberId 人员id
     * @return 配置列表
     */
    public List<Setting> list(Long memberId) {
        return new QSetting()
            .memberId.eq(memberId)
            .status.eq(CommStatus.ENABLED)
            .findList();
    }

    /**
     * 查询配置
     *
     * @param names    指定配置名称
     * @param memberId 人员id
     * @return 配置列表
     */
    public List<Setting> listByName(Collection<String> names, Long memberId) {
        return new QSetting()
            .name.in(names)
            .memberId.eq(memberId)
            .status.eq(CommStatus.ENABLED)
            .findList();
    }

    /**
     * 获取配置
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @param clazz    配置反序列化类型
     * @param <T>      配置类型
     * @return 配置
     */
    public <T> T getBean(String name, Long memberId, Class<T> clazz) {
        String content = get(name, memberId);
        if (StringUtils.hasText(content)) {
            try {
                return objectMapper.readValue(content, clazz);
            } catch (Exception e) {
                log.warn("读取配置失败: {}", e.getMessage());
            }
        }
        return null;
    }

    /**
     * 获取配置
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @param typeRef  反序列化类型
     * @param <T>      配置类型
     * @return 配置
     */
    public <T> T getBean(String name, Long memberId, TypeReference<T> typeRef) {
        String content = get(name, memberId);
        if (StringUtils.hasText(content)) {
            try {
                return objectMapper.readValue(content, typeRef);
            } catch (Exception e) {
                log.warn("读取配置失败: {}", e.getMessage());
            }
        }
        return null;
    }

    /**
     * 设置配置项
     *
     * @param name     配置名称
     * @param bean     配置内容
     * @param memberId 人员id
     * @return 配置
     */
    public Setting setBean(String name, Object bean, Long memberId) {
        Setting setting = findByName(name, memberId);
        if (setting == null) {
            setting = newSetting(name, memberId);
        }
        return setBean(setting, bean);
    }

    /**
     * 设置配置项
     *
     * @param setting 待持久化配置
     * @param bean    新的配置内容
     * @return 配置
     */
    public Setting setBean(Setting setting, Object bean) {
        String content = null;
        if (bean != null) {
            try {
                content = objectMapper.writeValueAsString(bean);
            } catch (Exception e) {
                log.warn("写入配置失败：{}", e.getMessage());
            }
        }
        setting.setContent(content);
        save(setting);
        return setting;
    }

    /**
     * 设置配置值
     *
     * @param name     配置名称
     * @param content  配置内容
     * @param memberId 人员id
     * @return 配置
     */
    public Setting set(String name, Object content, Long memberId) {
        Setting setting = findByName(name, memberId);
        if (setting == null) {
            setting = newSetting(name, memberId);
        }
        setting.setContent(Objects.toString(content, null));
        save(setting);
        return setting;
    }

    /**
     * 设置开关型配置值为开启
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置
     */
    public Setting setEnable(String name, Long memberId) {
        return set(name, Boolean.TRUE, memberId);
    }

    /**
     * 设置开关型配置值为关闭
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置
     */
    public Setting setDisable(String name, Long memberId) {
        return set(name, null, memberId);
    }

    /**
     * 获取string类型配置值
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置值
     */
    public String get(String name, Long memberId) {
        Setting setting = findByName(name, memberId);
        return setting == null ? null : setting.getContent();
    }

    /**
     * 获取byte类型配置值
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置值
     */
    public Byte getByte(String name, Long memberId) {
        String content = get(name, memberId);
        return StringUtils.hasText(content) ? Byte.valueOf(content) : null;
    }

    /**
     * 获取short类型配置值
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置值
     */
    public Short getShort(String name, Long memberId) {
        String content = get(name, memberId);
        return StringUtils.hasText(content) ? Short.valueOf(content) : null;
    }

    /**
     * 获取int类型配置值
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置值
     */
    public Integer getInt(String name, Long memberId) {
        String content = get(name, memberId);
        return StringUtils.hasText(content) ? Integer.valueOf(content) : null;
    }

    /**
     * 获取long类型配置值
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置值
     */
    public Long getLong(String name, Long memberId) {
        String content = get(name, memberId);
        return StringUtils.hasText(content) ? Long.valueOf(content) : null;
    }

    /**
     * 获取float类型配置值
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置值
     */
    public Float getFloat(String name, Long memberId) {
        String content = get(name, memberId);
        return StringUtils.hasText(content) ? Float.valueOf(content) : null;
    }

    /**
     * 获取double类型配置值
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置值
     */
    public Double getDouble(String name, Long memberId) {
        String content = get(name, memberId);
        return StringUtils.hasText(content) ? Double.valueOf(content) : null;
    }

    /**
     * 获取bool类型配置值
     *
     * @param name     配置名称
     * @param memberId 人员id
     * @return 配置值
     */
    public Boolean getBool(String name, Long memberId) {
        return isEnabled(name, memberId);
    }

    /**
     * 开关断定
     *
     * @param name 配置名
     * @return bool
     */
    public boolean isEnabled(String name) {
        return isEnabled(name, SystemConst.SYS_ID);
    }

    /**
     * 开关断定
     *
     * @param name     配置名
     * @param memberId 用户id
     * @return bool
     */
    public boolean isEnabled(String name, Long memberId) {
        String content = get(name, memberId);
        return !(content == null
            || "false".equalsIgnoreCase(content)
            || "0".equals(content)
            || "disable".equalsIgnoreCase(content)
            || "undefine".equalsIgnoreCase(content)
            || "off".equalsIgnoreCase(content)
            || "n".equalsIgnoreCase(content)
        );
    }

    /**
     * 创建配置对象
     *
     * @param name     配置名称
     * @param memberId 用户id
     * @return 配置实例
     */
    public Setting newSetting(String name, Long memberId) {
        Setting setting = new Setting();
        setting.setName(name);
        setting.setMemberId(memberId);
        return setting;
    }
}
