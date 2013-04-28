package com.befun.dao;

import java.io.Serializable;
import java.util.List;

import com.befun.dao.common.IQueryCondition;
import com.befun.domain.PaginationBean;

public interface ICommonDao {

    <M, PK extends Serializable> PK save(M model);

    <M> void saveOrUpdate(M model);

    <M> void update(M model);

    <M> void merge(M model);

    <M, PK extends Serializable> void delete(Class<M> entityClass, PK id);

    <M, PK extends Serializable> void delete(Class<M> entityClass, PK... ids);

    <M> void deleteObject(M model);

    <M> void deleteObject(M... models);

    <M, PK extends Serializable> M get(Class<M> entityClass, PK id);

    <M, PK extends Serializable> List<M> get(Class<M> entityClass, PK... ids);

    <M> Long count(Class<M> entityClass, IQueryCondition queryCondition);

    <M> List<M> query(Class<M> entityClass, IQueryCondition queryCondition);

    <T, M> List<T> queryGroup(Class<M> entityClass, IQueryCondition queryCondition);

    <M> PaginationBean<M> query(Class<M> entityClass, IQueryCondition queryCondition, long pageNumber, int pageSize);

    <M> Long countAll(Class<M> entityClass);

    <M> List<M> queryAll(Class<M> entityClass);

    <M> PaginationBean<M> queryAll(Class<M> entityClass, long pageNumber, int pageSize);

    <M, PK extends Serializable> boolean exists(Class<M> entityClass, PK id);

    void flush();

    void clear();
}
