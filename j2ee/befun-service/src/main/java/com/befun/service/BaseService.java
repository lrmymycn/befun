package com.befun.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.befun.dao.IBaseDao;
import com.befun.dao.common.IQueryCondition;
import com.befun.domain.BaseModel;
import com.befun.domain.PaginationBean;

@Transactional(rollbackFor = Exception.class)
public abstract class BaseService<M extends BaseModel<PK>, PK extends Serializable> implements IBaseService<M, PK> {

    protected IBaseDao<M, PK> dao;

    public abstract void setDao(IBaseDao<M, PK> dao);

    public String[] getUpdatingIgnoreProps(){
        return null;
    }
    
    @Override
    public PK save(M model) {
        Assert.notNull(model, "model should be not null!");
        return dao.save(model);
    }

    @Override
    public void merge(M model) {
        Assert.notNull(model, "model should be not null!");
        dao.merge(model);
    }

    @Override
    public void saveOrUpdate(M model) {
        Assert.notNull(model, "model should be not null!");
        if (model.getId() == null) {
            this.update(model);
        } else {
            this.save(model);
        }
    }

    @Override
    public void update(M model) {
        this.update(model, getUpdatingIgnoreProps());
    }

    @Override
    public void update(M model, String[] ignoreProps) {
        Assert.notNull(model, "model should be not null!");
        Assert.notNull(model.getId());
        M exist = this.dao.get(model.getId());
        Assert.notNull(exist, model.getClass() + " with id" + model.getId() + " can not be found!");
        BeanUtils.copyProperties(model, exist, ignoreProps);
        dao.update(exist);
    }

    @Override
    public void delete(PK id) {
        Assert.notNull(id, "id should be not null!");
        dao.delete(id);
    }

    @Override
    public void deleteObject(M model) {
        Assert.notNull(model, "model should be not null!");
        dao.deleteObject(model);
    }

    @Override
    @Transactional(readOnly = true)
    public M get(PK id) {
        Assert.notNull(id, "id should be not null!");
        return dao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long countAll() {
        return dao.countAll();
    }

    @Override
    public void delete(PK... ids) {
        dao.delete(ids);
    }

    @Override
    public void deleteObject(M... models) {
        dao.deleteObject(models);
    }

    @Override
    @Transactional(readOnly = true)
    public List<M> get(PK... ids) {
        return dao.get(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public long count(IQueryCondition queryCondition) {
        return this.dao.count(queryCondition);
    }

    @Override
    public List<M> query(IQueryCondition queryCondition) {
        return this.dao.query(queryCondition);
    }

    @Override
    @Transactional(readOnly = true)
    public PaginationBean<M> query(IQueryCondition queryCondition, long pageNumber, int pageSize) {
        return this.dao.query(queryCondition, pageNumber, pageSize);
    }

    @Override
    @Transactional(readOnly = true)
    public List<M> queryAll() {
        return this.dao.queryAll();
    }

    @Override
    @Transactional(readOnly = true)
    public PaginationBean<M> queryAll(long pageNumber, int pageSize) {
        return this.dao.queryAll(pageNumber, pageSize);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(PK id) {
        Assert.notNull(id, "id should be not null!");
        return this.dao.exists(id);
    }    
}
