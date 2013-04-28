package com.befun.service;

import java.io.Serializable;
import java.util.List;

import com.befun.dao.common.IQueryCondition;
import com.befun.domain.BaseModel;
import com.befun.domain.PaginationBean;

public interface IBaseService<M extends BaseModel<PK>, PK extends Serializable> {
    
    String[] getUpdatingIgnoreProps();

    PK save(M model);

    void saveOrUpdate(M model);

    void update(M model);
    
    void update(M model, String[] ignoreProps);

    void merge(M model);

    void delete(PK id);

    void delete(PK... ids);

    void deleteObject(M model);

    void deleteObject(M... models);

    M get(PK id);

    List<M> get(PK... ids);

    long count(IQueryCondition queryCondition);

    List<M> query(IQueryCondition queryCondition);

    PaginationBean<M> query(IQueryCondition queryCondition, long pageNumber, int pageSize);

    long countAll();

    List<M> queryAll();

    PaginationBean<M> queryAll(long pageNumber, int pageSize);

    boolean exists(PK id);
}
