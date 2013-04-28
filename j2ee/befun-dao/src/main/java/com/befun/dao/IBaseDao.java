package com.befun.dao;

import java.io.Serializable;
import java.util.List;

import com.befun.dao.common.IQueryCondition;
import com.befun.domain.PaginationBean;

public interface IBaseDao<M extends Serializable, PK extends Serializable> {

    PK save(M model);

    void saveOrUpdate(M model);

    void update(M model);

    void merge(M model);

    void delete(PK id);

    void delete(PK... ids);

    void deleteObject(M model);

    void deleteObject(M... models);

    M get(PK id);

    List<M> get(PK... ids);

    Long count(IQueryCondition queryCondition);

    List<M> query(IQueryCondition queryCondition);

    List<Object[]> queryGroup(IQueryCondition queryCondition);

    PaginationBean<M> query(IQueryCondition queryCondition, long pageNumber, int pageSize);

    Long countAll();

    List<M> queryAll();

    PaginationBean<M> queryAll(long pageNumber, int pageSize);

    boolean exists(PK id);

    void flush();

    void clear();

}
