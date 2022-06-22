package cn.cpoet.yunzhi.note.comm.core;


import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.api.core.IdGenerator;
import cn.cpoet.yunzhi.note.comm.util.UUIDUtil;

/**
 * 默认uuid实现
 *
 * @author wanggf
 */
public class SimpleUUIDGenerator implements IdGenerator<String> {
    /**
     * 全局公用
     */
    public final static IdGenerator<String> INSTANCE = new SimpleUUIDGenerator();

    @Override
    public String getName() {
        return SystemConst.GLOBAL_UUID_GENERATOR;
    }

    @Override
    public String nextId() {
        return UUIDUtil.randomPure();
    }
}
