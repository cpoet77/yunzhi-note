package cn.cpoet.yunzhi.note.domain.base;

import cn.cpoet.yunzhi.note.api.util.AppContextUtil;
import cn.cpoet.yunzhi.note.api.util.GenericsUtil;
import io.ebean.DB;
import io.ebean.Database;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * @author CPoet
 */
public abstract class SuperBaseServiceImpl<ENTITY, ID> implements SuperBaseService<ENTITY, ID> {

    protected final Class<ENTITY> entityClass = GenericsUtil.getActualTypeArgClass(getClass());
    protected final BaseRepository<ENTITY, ID> repository;

    public SuperBaseServiceImpl() {
        repository = buildRepository();
    }

    public SuperBaseServiceImpl(BaseRepository<ENTITY, ID> repository) {
        this.repository = repository;
    }

    protected BaseRepository<ENTITY, ID> buildRepository() {
        Database database = AppContextUtil.getBean(Database.class);
        if (database == null) {
            database = DB.getDefault();
        }
        return new BaseRepository<>(entityClass, database);
    }

    @Override
    public Class<ENTITY> getEntityClass() {
        return entityClass;
    }

    @Override
    public BaseRepository<ENTITY, ID> getRepository() {
        return repository;
    }

    @Override
    public ENTITY findById(ID id) {
        return id == null || isPersistId(id) ? null : repository.findById(id);
    }

    @Override
    public List<ENTITY> listAll() {
        return repository.findAll();
    }


    @Override
    public int save(Collection<ENTITY> entities) {
        return CollectionUtils.isEmpty(entities) ? 0 : repository.saveAll(entities);
    }

    @Override
    public void update(ENTITY entity) {
        if (entity != null) {
            repository.update(entity);
        }
    }

    @Override
    public boolean delete(ENTITY entity) {
        return entity == null || repository.delete(entity);
    }

    @Override
    public int delete(Collection<ENTITY> beans) {
        return CollectionUtils.isEmpty(beans) ? 0 : repository.deleteAll(beans);
    }

    @Override
    public void deleteById(ID id) {
        if (id != null && !isPersistId(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public void insert(ENTITY entity) {
        if (entity != null) {
            repository.insert(entity);
        }
    }

    @Override
    public void save(ENTITY entity) {
        if (entity != null) {
            repository.save(entity);
        }
    }

    @Override
    public boolean isPersistId(ID id) {
        return false;
    }
}
