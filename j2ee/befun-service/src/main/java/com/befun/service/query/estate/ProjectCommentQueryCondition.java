package com.befun.service.query.estate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.befun.dao.common.QueryCondition;
import com.befun.service.query.QCUtils;

public class ProjectCommentQueryCondition extends QueryCondition {

    private static final long serialVersionUID = 6528375925954290589L;

    private Long projectId;

    private Boolean enabled;

    public ProjectCommentQueryCondition() {
        super();
    }

    public ProjectCommentQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.projectId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "projectId"), this.projectId);
            rs.add(tmp);
        }
        if (this.enabled != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "comment.enabled"), this.enabled);
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
