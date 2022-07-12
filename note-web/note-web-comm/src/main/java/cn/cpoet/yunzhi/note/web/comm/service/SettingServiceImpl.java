package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.domain.dao.SettingDao;
import cn.cpoet.yunzhi.note.domain.model.Setting;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author CPoet
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {

    private final SettingDao settingDao;

    @Override
    public Map<String, Object> getPubSetting(List<String> name) {
        List<Setting> sysSettings;
        List<Setting> guestSettings;
        if (CollectionUtils.isEmpty(name)) {
            sysSettings = settingDao.list(SystemConst.SYS_ID);
            guestSettings = settingDao.list(SystemConst.GUEST_ID);
        } else {
            sysSettings = settingDao.listByName(name, SystemConst.SYS_ID);
            guestSettings = settingDao.listByName(name, SystemConst.GUEST_ID);
        }
        if (CollectionUtils.isEmpty(sysSettings) && CollectionUtils.isEmpty(guestSettings)) {
            return Collections.emptyMap();
        }
        Map<String, Object> result = new HashMap<>(sysSettings.size() + guestSettings.size());
        for (Setting sysSetting : sysSettings) {
            result.put(sysSetting.getName(), sysSetting.getContent());
        }
        for (Setting guestSetting : guestSettings) {
            result.put(guestSetting.getName(), guestSetting.getContent());
        }
        return result;
    }

    @Override
    public Map<String, Object> getSetting(Subject subject, List<String> name) {
        List<Setting> settings;
        if (CollectionUtils.isEmpty(name)) {
            settings = settingDao.list(subject.getUid());
        } else {
            settings = settingDao.listByName(name, subject.getUid());
        }
        if (CollectionUtils.isEmpty(settings)) {
            return Collections.emptyMap();
        }
        return settings.stream().collect(Collectors.toMap(Setting::getName, Setting::getContent));
    }
}
