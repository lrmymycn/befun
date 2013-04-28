package com.befun.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.befun.dao.common.IQueryCondition;
import com.befun.dao.common.PageUtil;
import com.befun.domain.PaginationBean;

@Component("CommonHibernateDao")
public class CommonHibernateDao implements ICommonDao {

    @Resource
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession() {
        // transaction must be exist, else can not get session.
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <M, PK extends Serializable> PK save(M model) {
        return (PK) getSession().save(model);
    }

    @Override
    public <M> void saveOrUpdate(M model) {
        getSession().saveOrUpdate(model);
    }

    @Override
    public <M> void update(M model) {
        getSession().update(model);
    }

    @Override
    public <M> void merge(M model) {
        getSession().merge(model);
    }

    @Override
    public <M, PK extends Serializable> void delete(Class<M> entityClass, PK id) {
        getSession().delete(this.get(entityClass, id));
    }

    @Override
    public <M, PK extends Serializable> void delete(Class<M> entityClass, PK... ids) {
        for (PK id : ids) {
            this.delete(entityClass, id);
        }
    }

    @Override
    public <M> void deleteObject(M model) {
        getSession().delete(model);
    }

    @Override
    public <M> void deleteObject(M... models) {
        for (M model : models) {
            this.deleteObject(model);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <M, PK extends Serializable> M get(Class<M> entityClass, PK id) {
        return (M) getSession().get(entityClass, id);
    }

    @Override
    public <M, PK extends Serializable> List<M> get(Class<M> entityClass, PK... ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <M> Long count(Class<M> entityClass, IQueryCondition queryCondition) {
        Long totalCount = this.aggregate(entityClass, queryCondition);
        return totalCount;
    }

    @Override
    public <M> List<M> query(Class<M> entityClass, IQueryCondition queryCondition) {
        if (queryCondition == null) {
            return this.queryAll(entityClass);
        }
        return this.list(entityClass, queryCondition);
    }

    @Override
    public <M> PaginationBean<M> query(Class<M> entityClass, IQueryCondition queryCondition, long pageNumber, int pageSize) {
        if (queryCondition == null) {
            return this.queryAll(entityClass, pageNumber, pageSize);
        }
        PaginationBean<M> paginationBean = new PaginationBean<M>();
        long totalCount = this.count(entityClass, queryCondition);
        paginationBean.setTotalCount(totalCount);
        paginationBean.setPageSize(pageSize);
        paginationBean.setPageNumber(pageNumber);
        List<M> models = this.list(entityClass, queryCondition, pageNumber, pageSize);
        paginationBean.setModels(models);
        return paginationBean;
    }

    @Override
    public <M> Long countAll(Class<M> entityClass) {
        Long totalCount = aggregate("select count(*) as n " + generateAllHql(entityClass), null);
        return totalCount;
    }

    @Override
    public <M> List<M> queryAll(Class<M> entityClass) {
        return list(generateAllHql(entityClass));
    }

    private <M> String generateAllHql(Class<M> entityClass) {
        return "from " + entityClass.getSimpleName();
    }

    @Override
    public <M> PaginationBean<M> queryAll(Class<M> entityClass, long pageNumber, int pageSize) {
        PaginationBean<M> paginationBean = new PaginationBean<M>();
        long totalCount = countAll(entityClass);
        paginationBean.setTotalCount(totalCount);
        paginationBean.setPageSize(pageSize);
        paginationBean.setPageNumber(pageNumber);
        List<M> models = list(generateAllHql(entityClass), pageNumber, pageSize, null);
        paginationBean.setModels(models);

        return paginationBean;
    }

    @Override
    public <M, PK extends Serializable> boolean exists(Class<M> entityClass, PK id) {
        return this.get(entityClass, id) != null;
    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void clear() {
        getSession().clear();
    }

    protected <M> List<M> list(Class<M> entityClass, IQueryCondition queryCondition, long pageNumber, int pageSize) {
        if (queryCondition.isHql()) {
            return this.list(queryCondition.getHqlString(), pageNumber, pageSize, queryCondition.getParametersMap());
        }
        Criteria criteria = getSession().createCriteria(entityClass, queryCondition.getSelfAlias());
        queryCondition.build(criteria);
        if (queryCondition.getGroupProperties() != null && queryCondition.getGroupProperties().size() > 0) {
            criteria.setProjection(Projections.rowCount());
        }
//        org.hibernate.internal.CriteriaImpl ci = (org.hibernate.internal.CriteriaImpl)criteria;
//        java.util.Iterator it = ci.iterateSubcriteria();
//        System.out.println("iterateSubcriteria");
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        it = ci.iterateExpressionEntries();
//        System.out.println("iterateExpressionEntries");
//        while(it.hasNext()){
//            Object o = it.next();
//            System.out.println(o);
//            if(o instanceof org.hibernate.criterion.ExistsSubqueryExpression){
//                org.hibernate.criterion.ExistsSubqueryExpression e = (org.hibernate.criterion.ExistsSubqueryExpression)o;
//                
//            }
//        }
//        System.out.println(criteria);
        return this.list(criteria, pageNumber, pageSize);
    }

    protected <M> List<M> list(String hql) {
        List<M> results = this.list(hql, -1, -1, null);
        return results;
    }

    protected <M> List<M> list(String hql, long pageNumber, int pageSize) {
        List<M> results = this.list(hql, pageNumber, pageSize, null);
        return results;
    }

    protected <M> List<M> list(String hql, Map<String, Object> paramMap) {
        List<M> results = this.list(hql, -1, -1, paramMap);
        return results;
    }

    @SuppressWarnings("unchecked")
    protected <M> List<M> list(String hql, long pageNumber, int pageSize, Map<String, Object> paramMap) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramMap);
        if (pageNumber > -1 && pageSize > -1) {
            query.setMaxResults(pageSize);
            int start = PageUtil.getPageStart(pageNumber, pageSize);
            if (start != 0) {
                query.setFirstResult(start);
            }
        }
        if (pageNumber < 0) {
            query.setFirstResult(0);
        }
        List<M> results = query.list();
        return results;
    }

    @SuppressWarnings("unchecked")
    protected <M> List<M> list(Criteria criteria, long pageNumber, int pageSize) {
        if (pageNumber > -1 && pageSize > -1) {
            criteria.setMaxResults(pageSize);
            int start = PageUtil.getPageStart(pageNumber, pageSize);
            if (start != 0) {
                criteria.setFirstResult(start);
            }
        }
        if (pageNumber < 0) {
            criteria.setFirstResult(0);
        }
        List<M> results = criteria.list();
        return results;
    }

    /**
     * 根据查询条件返回唯一一条记录
     */
    @SuppressWarnings("unchecked")
    protected <T> T unique(final String hql, List<Object> paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        return (T) query.setMaxResults(1).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    protected <T> T aggregate(final String hql, Map<String, Object> paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        return (T) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    protected <M, T> T aggregate(Class<M> entityClass, IQueryCondition queryCondition) {
        if (queryCondition.isHql()) {
            return this.aggregate(queryCondition.getHqlString(), queryCondition.getParametersMap());
        }
        Criteria criteria = getSession().createCriteria(entityClass, queryCondition.getSelfAlias());
        queryCondition.build(criteria);
        return (T) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    /**
     * 执行批处理语句.如 之间insert, update, delete 等.
     */
    protected int execteBulk(final String hql, List<Object> paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        Object result = query.executeUpdate();
        return result == null ? 0 : ((Integer) result).intValue();
    }

    protected int execteNativeBulk(final String natvieSQL, List<Object> paramlist) {
        Query query = getSession().createSQLQuery(natvieSQL);
        setParameters(query, paramlist);
        Object result = query.executeUpdate();
        return result == null ? 0 : ((Integer) result).intValue();
    }

    protected <M> List<M> list(Class<M> entityClass, final IQueryCondition queryCondition) {
        return list(entityClass, queryCondition, -1, -1);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> listByNative(final String nativeSQL, final int pn, final int pageSize, final List<Entry<String, Class<?>>> entityList,
                                    final List<Entry<String, Type>> scalarList, List<Object> paramlist) {

        SQLQuery query = getSession().createSQLQuery(nativeSQL);
        if (entityList != null) {
            for (Entry<String, Class<?>> entity : entityList) {
                query.addEntity(entity.getKey(), entity.getValue());
            }
        }
        if (scalarList != null) {
            for (Entry<String, Type> entity : scalarList) {
                query.addScalar(entity.getKey(), entity.getValue());
            }
        }

        setParameters(query, paramlist);

        if (pn > -1 && pageSize > -1) {
            query.setMaxResults(pageSize);
            int start = PageUtil.getPageStart(pn, pageSize);
            if (start != 0) {
                query.setFirstResult(start);
            }
        }
        List<T> result = query.list();
        return result;
    }

    @SuppressWarnings("unchecked")
    protected <T> T aggregateByNative(final String natvieSQL, final List<Entry<String, Type>> scalarList, List<Object> paramlist) {
        SQLQuery query = getSession().createSQLQuery(natvieSQL);
        if (scalarList != null) {
            for (Entry<String, Type> entity : scalarList) {
                query.addScalar(entity.getKey(), entity.getValue());
            }
        }

        setParameters(query, paramlist);

        Object result = query.uniqueResult();
        return (T) result;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> list(Criteria criteria) {
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public <T> T unique(Criteria criteria) {
        return (T) criteria.uniqueResult();
    }

    public <T> List<T> list(DetachedCriteria criteria) {
        return list(criteria.getExecutableCriteria(getSession()));
    }

    @SuppressWarnings("unchecked")
    public <T> T unique(DetachedCriteria criteria) {
        return (T) unique(criteria.getExecutableCriteria(getSession()));
    }

    protected void setParameters(Query query, List<Object> paramlist) {
        if (paramlist != null) {
            for (int i = 0; i < paramlist.size(); i++) {
                if (paramlist.get(i) instanceof Date) {
                    // TODO 难道这是bug 使用setParameter不行？？
                    query.setTimestamp(i, (Date) paramlist.get(i));
                } else {
                    query.setParameter(i, paramlist.get(i));
                }
            }
        }
    }

    protected void setParameters(Query query, Map<String, Object> paramMap) {
        if (paramMap != null) {
            String key = null;
            Object value = null;
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                if (value instanceof Collection) {
                    query.setParameterList(key, (Collection<?>) value);
                } else if (value instanceof Object[]) {
                    query.setParameterList(key, (Object[]) value);
                } else {
                    query.setParameter(key, value);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T, M> List<T> queryGroup(Class<M> entityClass, IQueryCondition queryCondition) {
        if (queryCondition.isHql()) {
            return this.list(queryCondition.getHqlString(), queryCondition.getParametersMap());
        }
        Criteria criteria = this.getSession().createCriteria(entityClass, queryCondition.getSelfAlias());
        queryCondition.build(criteria);
        return (List<T>) criteria.list();
    }
}
