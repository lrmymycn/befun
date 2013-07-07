package com.befun.service.query.estate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.befun.dao.common.QueryCondition;
import com.befun.service.query.QCUtils;

public class CustomerMessageQueryCondition extends QueryCondition {

    private static final long serialVersionUID = 6528375925954290589L;

    private Long floorplanId;

    private Long projectId;

    private Boolean processed;

    private Date fromCreationDate;

    private Date toCreationDate;

    private Date fromProcessDate;

    private Date toProcessDate;

    public CustomerMessageQueryCondition() {
        super();
    }

    public CustomerMessageQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.floorplanId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "floorplanId"), this.floorplanId);
            rs.add(tmp);
        } else if (this.projectId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "projectId"), this.projectId);
            rs.add(tmp);
        }
        if (this.processed != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "processed"), this.processed);
            rs.add(tmp);
        }
        if (this.fromCreationDate != null) {
            tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "creationDate"), this.fromCreationDate);
            rs.add(tmp);
        }
        if (this.toCreationDate != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "creationDate"), this.toCreationDate);
            rs.add(tmp);
        }
        if (this.fromProcessDate != null) {
            tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "processDate"), this.fromProcessDate);
            rs.add(tmp);
        }
        if (this.toProcessDate != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "processDate"), this.toProcessDate);
            rs.add(tmp);
        }
        return rs;
    }

    public Long getFloorplanId() {
        return floorplanId;
    }

    public void setFloorplanId(Long floorplanId) {
        this.floorplanId = floorplanId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Date getFromCreationDate() {
        return fromCreationDate;
    }

    public void setFromCreationDate(Date fromCreationDate) {
        this.fromCreationDate = fromCreationDate;
    }

    public Date getToCreationDate() {
        return toCreationDate;
    }

    public void setToCreationDate(Date toCreationDate) {
        this.toCreationDate = toCreationDate;
    }

    public Date getFromProcessDate() {
        return fromProcessDate;
    }

    public void setFromProcessDate(Date fromProcessDate) {
        this.fromProcessDate = fromProcessDate;
    }

    public Date getToProcessDate() {
        return toProcessDate;
    }

    public void setToProcessDate(Date toProcessDate) {
        this.toProcessDate = toProcessDate;
    }

}
