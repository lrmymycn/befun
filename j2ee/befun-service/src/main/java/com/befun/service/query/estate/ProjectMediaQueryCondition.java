package com.befun.service.query.estate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.befun.service.query.QCUtils;
import com.befun.service.query.QueryConstants;

public class ProjectMediaQueryCondition extends EstateQueryCondition {

    private static final long serialVersionUID = -6598557222944301951L;

    private String projectAlias = QueryConstants.ALIAS_PROJECT;

    private String mediaAlias = QueryConstants.ALIAS_MEDIA;

    private String projectBid;

    private String mediaBid;

    private Long projectId;

    private Long mediaId;

    public ProjectMediaQueryCondition() {
        super();
    }

    public ProjectMediaQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public ProjectMediaQueryCondition(String selfAlias, String projectAlias, String mediaAlias) {
        super(selfAlias);
        this.projectAlias = projectAlias;
        this.mediaAlias = mediaAlias;
    }
    
    @Override
    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.projectId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getProjectAlias(), "id"), this.projectId);
            rs.add(tmp);
        } else if (this.projectBid != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getProjectAlias(), "bid"), this.projectBid);
            rs.add(tmp);
        }

        if (this.mediaId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getMediaAlias(), "id"), this.mediaId);
            rs.add(tmp);
        } else if (this.mediaBid != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getMediaAlias(), "bid"), this.mediaBid);
            rs.add(tmp);
        }

        return rs;
    }

    @Override
    public void setAlias(Criteria criteria) {
        criteria.createAlias("project", this.getProjectAlias());
        criteria.createAlias("media", this.getMediaAlias());
    }

    public String getProjectBid() {
        return projectBid;
    }

    public void setProjectBid(String projectBid) {
        this.projectBid = projectBid;
    }

    public String getMediaBid() {
        return mediaBid;
    }

    public void setMediaBid(String mediaBid) {
        this.mediaBid = mediaBid;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public String getProjectAlias() {
        return projectAlias;
    }

    public void setProjectAlias(String projectAlias) {
        this.projectAlias = projectAlias;
    }

    public String getMediaAlias() {
        return mediaAlias;
    }

    public void setMediaAlias(String mediaAlias) {
        this.mediaAlias = mediaAlias;
    }

}
