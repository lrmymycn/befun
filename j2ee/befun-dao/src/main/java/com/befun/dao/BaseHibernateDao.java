package com.befun.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import com.befun.dao.common.IQueryCondition;
import com.befun.dao.common.PageUtil;
import com.befun.domain.PaginationBean;

public class BaseHibernateDao<M extends Serializable, PK extends Serializable> implements IBaseDao<M, PK> {

    protected final Log log = LogFactory.getLog(BaseHibernateDao.class);

    private final Class<M> entityClass;

    private final String HQL_LIST_ALL;

    private final String HQL_COUNT_ALL;

    private String pkName = "id";

    @SuppressWarnings("unchecked")
    public BaseHibernateDao() {
        this.entityClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Field[] fields = this.entityClass.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Id.class)) {
                this.pkName = f.getName();
            }
        }
        Assert.notNull(pkName);
        HQL_LIST_ALL = "from " + this.entityClass.getSimpleName() + " order by " + this.pkName + " desc";
        HQL_COUNT_ALL = " select count(*) from " + this.entityClass.getSimpleName();
    }

    @Resource
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession() {
        // transaction must be exist, else can not get session.
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public PK save(M model) {
        return (PK) getSession().save(model);
    }

    @Override
    public void saveOrUpdate(M model) {
        getSession().saveOrUpdate(model);
    }

    @Override
    public void update(M model) {
        getSession().update(model);
    }

    @Override
    public void merge(M model) {
        getSession().merge(model);
    }

    @Override
    public void delete(PK id) {
        getSession().delete(this.get(id));
    }

    @Override
    public void delete(PK... ids) {
        for (PK id : ids) {
            this.delete(id);
        }
    }

    @Override
    public void deleteObject(M model) {
        getSession().delete(model);
    }

    @Override
    public void deleteObject(M... models) {
        for (M model : models) {
            this.deleteObject(model);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public M get(PK id) {
        return (M) getSession().get(this.entityClass, id);
    }

    @Override
    public List<M> get(PK... ids) {
        if (ids == null) {
            return new ArrayList<M>();
        }
        List<M> rs = new ArrayList<M>();
        for (PK id : ids) {
            rs.add(this.get(id));
        }
        return rs;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> query(String hql, Map<String, Object> paramMap) {
        Query query = this.getSession().createQuery(hql);
        this.setParameters(query, paramMap);
        return (List<T>)query.list();
    }

    @Override
    public int execute(String hql, Map<String, Object> paramMap) {
        Query query = this.getSession().createQuery(hql);
        this.setParameters(query, paramMap);
        return query.executeUpdate();
    }

    @Override
    public Long count(IQueryCondition queryCondition) {
        return this.aggregate(queryCondition);
    }

    @Override
    public List<M> query(IQueryCondition queryCondition) {
        if (queryCondition == null) {
            return this.queryAll();
        }
        return this.list(queryCondition);
    }

    @Override
    public PaginationBean<M> query(IQueryCondition queryCondition, long pageNumber, int pageSize) {
        if (queryCondition == null) {
            return this.queryAll(pageNumber, pageSize);
        }
        PaginationBean<M> paginationBean = new PaginationBean<M>();
        long totalCount = this.count(queryCondition);
        paginationBean.setTotalCount(totalCount);
        paginationBean.setPageSize(pageSize);
        paginationBean.setPageNumber(pageNumber);
        List<M> models = list(queryCondition, pageNumber, pageSize);
        paginationBean.setModels(models);
        return paginationBean;
    }

    @Override
    public Long countAll() {
        Long totalCount = aggregate(HQL_COUNT_ALL, (List<Object>) null);
        return totalCount;
    }

    @Override
    public List<M> queryAll() {
        return list(HQL_LIST_ALL);
    }

    @Override
    public PaginationBean<M> queryAll(long pageNumber, int pageSize) {
        PaginationBean<M> paginationBean = new PaginationBean<M>();
        long totalCount = countAll();
        paginationBean.setTotalCount(totalCount);
        paginationBean.setPageSize(pageSize);
        paginationBean.setPageNumber(pageNumber);
        List<M> models = list(HQL_LIST_ALL, pageNumber, pageSize);
        paginationBean.setModels(models);

        return paginationBean;
    }

    @Override
    public boolean exists(PK id) {
        return get(id) != null;
    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void clear() {
        getSession().clear();
    }

    /**
     * for in
     */
    @SuppressWarnings("unchecked")
    protected <T> List<T> listWithIn(final String hql, final int start, final int length, final Map<String, Collection<?>> map, List<Object> paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        for (Entry<String, Collection<?>> e : map.entrySet()) {
            query.setParameterList(e.getKey(), e.getValue());
        }
        if (start > -1 && length > -1) {
            query.setMaxResults(length);
            if (start != 0) {
                query.setFirstResult(start);
            }
        }
        List<T> results = query.list();
        return results;
    }

    protected <T> List<T> list(IQueryCondition queryCondition, long pageNumber, int pageSize) {
        if (queryCondition.isHql()) {
            return this.list(queryCondition.getHqlString(), pageNumber, pageSize, queryCondition.getParametersMap());
        }
        Criteria criteria = getSession().createCriteria(this.entityClass, queryCondition.getSelfAlias());
        queryCondition.build(criteria);
        return this.list(criteria, pageNumber, pageSize);
    }

    protected <T> List<T> list(String hql) {
        List<T> results = this.list(hql, null);
        return results;
    }

    protected <T> List<T> list(String hql, Map<String, Object> paramMap) {
        List<T> results = this.list(hql, -1l, -1, paramMap);
        return results;
    }

    protected <T> List<T> list(String hql, long pageNumber, int pageSize) {
        List<T> results = this.list(hql, pageNumber, pageSize, null);
        return results;
    }

    @SuppressWarnings("unchecked")
    protected <T> List<T> list(String hql, long pageNumber, int pageSize, Map<String, Object> paramMap) {
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
        List<T> results = query.list();
        return results;
    }

    @SuppressWarnings("unchecked")
    protected <T> List<T> list(Criteria criteria, long pageNumber, int pageSize) {
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
        List<T> results = criteria.list();
        return results;
    }

    /**
     * 鏍规嵁鏌ヨ鏉′欢杩斿洖鍞竴涓�潯璁板綍
     */
    @SuppressWarnings("unchecked")
    protected <T> T unique(final String hql, List<Object> paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        return (T) query.setMaxResults(1).uniqueResult();
    }

    /**
     * 
     * for in
     */
    @SuppressWarnings("unchecked")
    protected <T> T aggregate(String hql, Map<String, Collection<?>> map, List<Object> paramlist) {
        Query query = getSession().createQuery(hql);
        if (paramlist != null) {
            setParameters(query, paramlist);
            for (Entry<String, Collection<?>> e : map.entrySet()) {
                query.setParameterList(e.getKey(), e.getValue());
            }
        }

        return (T) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    protected <T> T aggregate(String hql, List<Object> paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);

        return (T) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    protected <T> T aggregate(String hql, Map<String, Object> paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        return (T) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    protected <T> T aggregate(IQueryCondition queryCondition) {
        if (queryCondition.isHql()) {
            return this.aggregate(queryCondition.getHqlString(), queryCondition.getParametersMap());
        }
        Criteria criteria = getSession().createCriteria(this.entityClass, queryCondition.getSelfAlias());
        queryCondition.build(criteria);
        criteria.setProjection(Projections.rowCount());
        return (T) criteria.uniqueResult();
    }

    /**
     * 鎵ц鎵瑰鐞嗚鍙�濡�涔嬮棿insert, update, delete 绛�
     */
    protected int execteBulk(String hql, List<Object> paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        Object result = query.executeUpdate();
        return result == null ? 0 : ((Integer) result).intValue();
    }

    protected int execteNativeBulk(String natvieSQL, List<Object> paramlist) {
        Query query = getSession().createSQLQuery(natvieSQL);
        setParameters(query, paramlist);
        Object result = query.executeUpdate();
        return result == null ? 0 : ((Integer) result).intValue();
    }

    protected <T> List<T> list(IQueryCondition queryCondition) {
        return list(queryCondition, -1, -1);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> listByNative(String nativeSQL, long pageNumber, int pageSize, List<Entry<String, Class<?>>> entityList,
                                    List<Entry<String, Type>> scalarList, List<Object> paramlist) {

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

        if (pageNumber > -1 && pageSize > -1) {
            query.setMaxResults(pageSize);
            int start = PageUtil.getPageStart(pageNumber, pageSize);
            if (start != 0) {
                query.setFirstResult(start);
            }
        }
        List<T> result = query.list();
        return result;
    }

    @SuppressWarnings("unchecked")
    protected <T> T aggregateByNative(String natvieSQL, List<Entry<String, Type>> scalarList, List<Object> paramlist) {
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
                    // TODO 闅鹃亾杩欐槸bug 浣跨敤setParameter涓嶈锛燂紵
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
    public List<Object[]> queryGroup(IQueryCondition queryCondition) {
        if (queryCondition.isHql()) {
            return this.list(queryCondition.getHqlString(), queryCondition.getParametersMap());
        }
        Criteria criteria = this.getSession().createCriteria(this.entityClass, queryCondition.getSelfAlias());
        queryCondition.build(criteria);
        return (List<Object[]>) criteria.list();
    }

    @Override
    public <T> List<T> queryFree(IQueryCondition queryCondition) {
        List<T> models = list(queryCondition);
        return models;
    }

    @Override
    public <T> PaginationBean<T> queryFree(IQueryCondition queryCondition, long pageNumber, int pageSize) {
        if (queryCondition == null) {
            return this.queryFreeAll(pageNumber, pageSize);
        }
        PaginationBean<T> paginationBean = new PaginationBean<T>();
        long totalCount = this.count(queryCondition);
        paginationBean.setTotalCount(totalCount);
        paginationBean.setPageSize(pageSize);
        paginationBean.setPageNumber(pageNumber);
        List<T> models = list(queryCondition, pageNumber, pageSize);
        paginationBean.setModels(models);
        return paginationBean;
    }

    @Override
    public <T> PaginationBean<T> queryFreeAll(long pageNumber, int pageSize) {
        PaginationBean<T> paginationBean = new PaginationBean<T>();
        long totalCount = countAll();
        paginationBean.setTotalCount(totalCount);
        paginationBean.setPageSize(pageSize);
        paginationBean.setPageNumber(pageNumber);
        Criteria criteria = getSession().createCriteria(this.entityClass);
        List<T> models = list(criteria, pageNumber, pageSize);
        paginationBean.setModels(models);
        return paginationBean;
    }
}
