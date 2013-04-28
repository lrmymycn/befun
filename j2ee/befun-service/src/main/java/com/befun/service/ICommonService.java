package com.befun.service;

import java.io.Serializable;
import java.util.List;

import com.befun.dao.common.IQueryCondition;
import com.befun.domain.PaginationBean;

public interface ICommonService {

    <M extends Serializable, PK extends Serializable> PK save(M model);

    <M extends Serializable> void saveOrUpdate(M model);

    <M extends Serializable> void update(M model);

    <M extends Serializable> void merge(M model);

    <M extends Serializable, PK extends Serializable> void delete(Class<M> entityClass, PK id);

    <M extends Serializable, PK extends Serializable> void delete(Class<M> entityClass, PK... ids);

    <M extends Serializable> void deleteObject(M model);

    <M extends Serializable> void deleteObject(M... models);

    
    <M extends Serializable, PK extends Serializable> M get(Class<M> entityClass, PK id);

    <M extends Serializable, PK extends Serializable> List<M> get(Class<M> entityClass, PK... ids);
    
    <M extends Serializable> M getByBid(Class<M> entityClass, String bid);

    <M extends Serializable> long count(Class<M> entityClass, IQueryCondition queryCondition);

    <M extends Serializable> List<M> query(Class<M> entityClass, IQueryCondition queryCondition);

    <M extends Serializable> PaginationBean<M> query(Class<M> entityClass, IQueryCondition queryCondition, long pageNumber, int pageSize);

    <M extends Serializable> long countAll(Class<M> entityClass);

    <M extends Serializable> List<M> queryAll(Class<M> entityClass);

    <M extends Serializable> PaginationBean<M> queryAll(Class<M> entityClass, long pageNumber, int pageSize);

    <M extends Serializable, PK extends Serializable> boolean exists(Class<M> entityClass, PK id);
}
