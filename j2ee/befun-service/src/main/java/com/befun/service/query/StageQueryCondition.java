package com.befun.service.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class StageQueryCondition extends EstateQueryCondition {

    private static final long serialVersionUID = 1574250681229084211L;

    private Long projectId;

    private String key;

    public StageQueryCondition() {
        super();
    }

    public StageQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    @Override
    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.projectId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "project.Id"), this.projectId);
            rs.add(tmp);
        }
        if (this.key != null) {
            tmp = Restrictions.or(Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "description"), this.key, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "name"), this.key, MatchMode.ANYWHERE));
            rs.add(tmp);
        }

        return rs;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "StageQueryCondition [projectId=" + projectId + ", key=" + key + ", toString()=" + super.toString() + "]";
    }

}
