package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.web.comm.param.I18nQueryParam;
import cn.cpoet.yunzhi.note.web.comm.vo.I18nMapVO;

/**
 * @author CPoet
 */
public interface I18nService {
    /**
     * 查询国际化包
     *
     * @param i18nQueryParam 查询参数
     * @return 国际化
     */
    I18nMapVO listI18n(I18nQueryParam i18nQueryParam);
}
