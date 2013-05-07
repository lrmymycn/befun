package com.befun.dao.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class QueryCondition implements IQueryCondition, Cloneable {

    private static final long serialVersionUID = -8922498272757206238L;

    private String selfAlias = "this";

    private OrderBy orderBy = new OrderBy();

    private List<String> groupProperties = new ArrayList<String>();

    private List<Criterion> criterions = new ArrayList<Criterion>();

    private List<FetchConfig> fetchConfigs = new ArrayList<FetchConfig>();
    
    private ProjectionList projections = null;

    private boolean hql = false;

    private String hqlString;

    private Map<String, Object> parameterMap = new HashMap<String, Object>();

    public QueryCondition() {
        super();
    }

    public QueryCondition(String selfAlias) {
        super();
        this.selfAlias = selfAlias;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
    }

    public List<Criterion> getCriterions() {
        return criterions;
    }

    public void addCriterions(Criterion criterion) {
        this.criterions.add(criterion);
    }

    public boolean isHql() {
        return this.hql;
    }

    public void setHql(boolean hql) {
        this.hql = hql;
    }

    public String getHqlString() {
        if (this.isHql()) {
            return hqlString;
        }
        throw new IllegalStateException("Current query condition is not HQL!");
    }

    public void setHqlString(String hqlString) {
        if (this.isHql()) {
            this.hqlString = hqlString;
            return;
        }
        throw new IllegalStateException("Current query condition is not HQL!");
    }

    @Override
    public Map<String, Object> getParametersMap() {
        if (this.isHql()) {
            return this.parameterMap;
        }
        throw new IllegalStateException("Current query condition is not HQL!");
    }

    @Override
    public void setParameter(String parameterName, Object parameterValue) {
        if (this.isHql()) {
            this.parameterMap.put(parameterName, parameterValue);
            return;
        }
        throw new IllegalStateException("Current query condition is not HQL!");
    }

    @Override
    public void removeParameter(String parameterName) {
        if (this.isHql()) {
            this.parameterMap.remove(parameterName);
            return;
        }
        throw new IllegalStateException("Current query condition is not HQL!");
    }

    public List<FetchConfig> getFetchConfigs() {
        return fetchConfigs;
    }

    public void addFetchConfigs(FetchConfig fetchConfig) {
        this.fetchConfigs.add(fetchConfig);
    }

    protected void buildFetchConfig(Criteria criteria) {
        for (FetchConfig f : this.fetchConfigs) {
            criteria.setFetchMode(f.getPropertyName(), f.getFetchMode());
        }
    }

    protected void buildOrder(Criteria criteria) {
        if (getOrderBy() != null) {
            getOrderBy().build(criteria);
        }
    }

    protected void buildCriterions(Criteria criteria) {
        for (Criterion criterion : getCriterions()) {
            criteria.add(criterion);
        }
    }

    protected void buildGroup(Criteria criteria) {
        if (groupProperties == null || groupProperties.isEmpty()) {
            return;
        }
        ProjectionList projections = Projections.projectionList();
        for (String g : groupProperties) {
            projections.add(Projections.groupProperty(g));
        }
        projections.add(Projections.rowCount());
        criteria.setProjection(projections);
    }

    protected void buildProjection(Criteria criteria) {
        if (this.projections == null) {
            return;
        }
        criteria.setProjection(projections);
    }
    
    protected void setAlias(Criteria criteria) {
    }

    public void setAlias(DetachedCriteria criteria) {
    }

    @Override
    public void build(Criteria criteria) {
        this.setAlias(criteria);
        this.buildFetchConfig(criteria);
        this.buildOrder(criteria);
        this.buildCriterions(criteria);
        this.buildGroup(criteria);
        this.buildProjection(criteria);
    }

    public boolean isEmpty() {
        if (this.isHql()) {
            return StringUtils.isBlank(this.getHqlString());
        }
        return this.getCriterions().isEmpty();
    }

    public String getSelfAlias() {
        return selfAlias;
    }

    public void setSelfAlias(String selfAlias) {
        this.selfAlias = selfAlias;
    }

    public void setGroupProperties(List<String> groupProperties) {
        this.groupProperties = groupProperties;
    }

    public List<String> getGroupProperties() {
        return this.groupProperties;
    }

    public void setProjections(ProjectionList projections) {
        this.projections = projections;
    }

    @Override
    public String toString() {
        return "QueryCondition [selfAlias=" + selfAlias + ", orderBy=" + orderBy + ", groupProperties=" + groupProperties + ", criterions=" + criterions
               + ", fetchConfigs=" + fetchConfigs + ", hql=" + hql + ", hqlString=" + hqlString + ", parameterMap=" + parameterMap + "]";
    }

}
