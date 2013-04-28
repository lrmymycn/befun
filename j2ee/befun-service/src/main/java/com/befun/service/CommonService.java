package com.befun.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.ICommonDao;
import com.befun.dao.common.IQueryCondition;
import com.befun.dao.common.QueryCondition;
import com.befun.domain.PaginationBean;

@Service("CommonService")
@Transactional(rollbackFor = Exception.class)
public class CommonService implements ICommonService {

    @Autowired
    @Qualifier("CommonHibernateDao")
    private ICommonDao dao;

    @Override
    public <M extends Serializable, PK extends Serializable> PK save(M model) {
        return this.dao.save(model);
    }

    @Override
    public <M extends Serializable> void saveOrUpdate(M model) {
        this.dao.saveOrUpdate(model);
    }

    @Override
    public <M extends Serializable> void update(M model) {
        this.dao.update(model);
    }

    @Override
    public <M extends Serializable> void merge(M model) {
        this.dao.merge(model);
    }

    @Override
    public <M extends Serializable, PK extends Serializable> void delete(Class<M> entityClass, PK id) {
        this.dao.delete(entityClass, id);
    }

    @Override
    public <M extends Serializable, PK extends Serializable> void delete(Class<M> entityClass, PK... ids) {
        this.dao.delete(entityClass, ids);
    }

    @Override
    public <M extends Serializable> void deleteObject(M model) {
        this.dao.deleteObject(model);
    }

    @Override
    public <M extends Serializable> void deleteObject(M... models) {
        this.dao.deleteObject(models);
    }

    @Override
    public <M extends Serializable, PK extends Serializable> M get(Class<M> entityClass, PK id) {
        return this.dao.get(entityClass, id);
    }

    @Override
    public <M extends Serializable, PK extends Serializable> List<M> get(Class<M> entityClass, PK... ids) {
        return this.dao.get(entityClass, ids);
    }

    @Override
    public <M extends Serializable> M getByBid(Class<M> entityClass, String bid) {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.addCriterions(Restrictions.eq("bid", bid));
        List<M> list = this.dao.query(entityClass, queryCondition);
        if(list == null || list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    @Override
    public <M extends Serializable> long count(Class<M> entityClass, IQueryCondition queryCondition) {
        return this.dao.count(entityClass, queryCondition);
    }

    @Override
    public <M extends Serializable> List<M> query(Class<M> entityClass, IQueryCondition queryCondition) {
        return this.dao.query(entityClass, queryCondition);
    }

    @Override
    public <M extends Serializable> PaginationBean<M> query(Class<M> entityClass, IQueryCondition queryCondition, long pageNumber, int pageSize) {
        return this.dao.query(entityClass, queryCondition, pageNumber, pageSize);
    }

    @Override
    public <M extends Serializable> long countAll(Class<M> entityClass) {
        return this.dao.countAll(entityClass);
    }

    @Override
    public <M extends Serializable> List<M> queryAll(Class<M> entityClass) {
        return this.dao.queryAll(entityClass);
    }

    @Override
    public <M extends Serializable> PaginationBean<M> queryAll(Class<M> entityClass, long pageNumber, int pageSize) {
        return this.dao.queryAll(entityClass, pageNumber, pageSize);
    }

    @Override
    public <M extends Serializable, PK extends Serializable> boolean exists(Class<M> entityClass, PK id) {
        return this.dao.exists(entityClass, id);
    }


}
