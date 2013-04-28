package com.befun.dao.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;

public interface IQueryCondition extends Serializable {

    void build(Criteria criteria);

    boolean isHql();

    void setHql(boolean hql);

    String getHqlString();

    void setHqlString(String hqlString);

    Map<String, Object> getParametersMap();

    void setParameter(String parameterName, Object parameterValue);

    void removeParameter(String parameterName);

    /**
     * 查询条件是否是空的，不包含排序，fetch等策略
     * @return
     */
    boolean isEmpty();

    String getSelfAlias();

    void setGroupProperties(List<String> groupProperties);

    List<String> getGroupProperties();
}
