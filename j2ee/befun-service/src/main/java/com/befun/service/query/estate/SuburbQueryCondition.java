package com.befun.service.query.estate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.befun.service.query.QCUtils;
import com.befun.service.query.QueryConstants;

public class SuburbQueryCondition extends EstateQueryCondition {

    private static final long serialVersionUID = -4832647041758889587L;

    private Long areaId;

    private Boolean universities;

    private Boolean schools;

    private Boolean shoppingCenter;

    private Boolean train;

    private Boolean chineseCommunity;

    private String key;

    public SuburbQueryCondition() {
        super();
        this.setSelfAlias(QueryConstants.ALIAS_SUBURB);
    }

    public SuburbQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    @Override
    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.areaId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "area.id"), this.areaId);
            rs.add(tmp);
        }
        if (this.chineseCommunity != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "chineseCommunity"), this.chineseCommunity);
            rs.add(tmp);
        }
        if (this.schools != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "schools"), this.schools);
            rs.add(tmp);
        }
        if (this.shoppingCenter != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "shoppingCenter"), this.shoppingCenter);
            rs.add(tmp);
        }
        if (this.train != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "train"), this.train);
            rs.add(tmp);
        }
        if (this.universities != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "universities"), this.universities);
            rs.add(tmp);
        }
        if (this.key != null) {
            tmp = Restrictions.or(Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "postCode"), this.key, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "name"), this.key, MatchMode.ANYWHERE));
            rs.add(tmp);
        }

        return rs;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Boolean getUniversities() {
        return universities;
    }

    public void setUniversities(Boolean universities) {
        this.universities = universities;
    }

    public Boolean getSchools() {
        return schools;
    }

    public void setSchools(Boolean schools) {
        this.schools = schools;
    }

    public Boolean getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(Boolean shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }

    public Boolean getTrain() {
        return train;
    }

    public void setTrain(Boolean train) {
        this.train = train;
    }

    public Boolean getChineseCommunity() {
        return chineseCommunity;
    }

    public void setChineseCommunity(Boolean chineseCommunity) {
        this.chineseCommunity = chineseCommunity;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "SuburbQueryCondition [areaId=" + areaId + ", universities=" + universities + ", schools=" + schools + ", shoppingCenter=" + shoppingCenter
               + ", train=" + train + ", chineseCommunity=" + chineseCommunity + ", key=" + key + "]";
    }

}
