package com.befun.service.query.estate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.befun.dao.common.QueryCondition;
import com.befun.service.query.QCUtils;

public class EstateQueryCondition extends QueryCondition {

    private static final long serialVersionUID = -3560114334052880921L;

    private String bid = null;

    private Boolean soldOut = null;

    private Boolean enabled = true;

    private Boolean removed = false;

    public EstateQueryCondition() {
        super();
    }

    public EstateQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    @Override
    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.bid != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "bid"), this.bid);
            rs.add(tmp);
        }
        if (this.soldOut != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "soldOut"), this.soldOut);
            rs.add(tmp);
        }
        if (this.enabled != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "modelModification.enabled"), this.enabled);
            rs.add(tmp);
        }
        if (this.removed != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "modelModification.removed"), this.removed);
            rs.add(tmp);
        }
        return rs;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    @Override
    public String toString() {
        return "EstateQueryCondition [bid=" + bid + ", soldOut=" + soldOut + ", enabled=" + enabled + ", removed=" + removed + ", toString()="
               + super.toString() + "]";
    }

}
