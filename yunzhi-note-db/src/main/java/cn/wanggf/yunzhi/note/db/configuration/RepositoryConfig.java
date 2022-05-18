package cn.wanggf.yunzhi.note.db.configuration;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author wanggf
 */
@ImportAutoConfiguration({
    EBeanConfig.class
})
@EntityScan("cn.wanggf.yunzhi.note.comm.domain")
public class RepositoryConfig {
}
