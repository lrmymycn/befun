package com.befun.service.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class AreaQueryCondition extends EstateQueryCondition {

    private static final long serialVersionUID = -4832647041758889587L;

    private String name;

    public AreaQueryCondition() {
        super();
    }

    public AreaQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    @Override
    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.name != null) {
            tmp = Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "name"), this.name, MatchMode.ANYWHERE);
            rs.add(tmp);
        }
        return rs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AreaQueryCondition [name=" + name + ", toString()=" + super.toString() + "]";
    }

}
