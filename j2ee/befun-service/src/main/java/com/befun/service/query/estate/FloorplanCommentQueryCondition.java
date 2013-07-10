package com.befun.service.query.estate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.befun.dao.common.QueryCondition;
import com.befun.service.query.QCUtils;

public class FloorplanCommentQueryCondition extends QueryCondition {

    private static final long serialVersionUID = 6528375925954290589L;

    private String commentAlias = "com";

    private Long floorplanId;

    private Boolean enabled;

    public FloorplanCommentQueryCondition() {
        super();
    }

    public FloorplanCommentQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public FloorplanCommentQueryCondition(String selfAlias, String commentAlias) {
        super(selfAlias);
        this.commentAlias = commentAlias;
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.floorplanId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "floorplanId"), this.floorplanId);
            rs.add(tmp);
        }
        if (this.enabled != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getCommentAlias(), "enabled"), this.enabled);
            rs.add(tmp);
        }
        return rs;
    }

    @Override
    public void setAlias(Criteria criteria) {
        criteria.createAlias(QCUtils.generatePropertyName(this.getSelfAlias(), "comment"), this.getCommentAlias());
    }

    public String getCommentAlias() {
        return commentAlias;
    }

    public void setCommentAlias(String commentAlias) {
        this.commentAlias = commentAlias;
    }

    public Long getFloorplanId() {
        return floorplanId;
    }

    public void setFloorplanId(Long floorplanId) {
        this.floorplanId = floorplanId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
