package com.befun.service.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class BuildingQueryCondition extends EstateQueryCondition {

    private static final long serialVersionUID = 6198820210097892418L;

    private String stageAlias = QueryConstants.ALIAS_STAGE;

    private String projectAlias = QueryConstants.ALIAS_PROJECT;

    private Long projectId;

    private ProjectQueryCondition pQC;

    private Long stageId;

    private Boolean readyHouse;

    private String buildingNumber;

    public BuildingQueryCondition() {
        super();
    }

    public BuildingQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public BuildingQueryCondition(String selfAlias, String stageAlias, String projectAlias) {
        super(selfAlias);
        this.stageAlias = stageAlias;
        this.projectAlias = projectAlias;
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.stageId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(getSelfAlias(), "stage.id"), this.stageId);
            rs.add(tmp);
        } else {
            if (this.projectId != null) {
                tmp = Restrictions.eq(QCUtils.generatePropertyName(getStageAlias(), "project.id"), this.projectId);
                rs.add(tmp);
            } else if (this.pQC != null && !this.pQC.isEmpty()) {
                rs.addAll(pQC.getCriterions());
            }
        }

        if (this.readyHouse != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(getSelfAlias(), "readyHouse"), this.readyHouse);
            rs.add(tmp);
        }
        if (this.buildingNumber != null) {
            tmp = Restrictions.like(QCUtils.generatePropertyName(getSelfAlias(), "buildingNumber"), this.buildingNumber, MatchMode.ANYWHERE);
            rs.add(tmp);
        }

        return rs;
    }

    @Override
    public void setAlias(Criteria criteria) {
        if (this.stageId == null && this.projectId != null) {
            criteria.createAlias(QCUtils.generatePropertyName(getSelfAlias(), "stage"), getStageAlias());
        } else if (this.pQC != null && !this.pQC.isEmpty()) {
            this.pQC.setSelfAlias(this.getProjectAlias());
            criteria.createAlias(QCUtils.generatePropertyName(getStageAlias(), "project"), getProjectAlias());
            this.pQC.setAlias(criteria);
        }
    }

    @Override
    public void setAlias(DetachedCriteria criteria) {
        if (this.stageId == null && this.projectId != null) {
            // criteria.createAlias(QCUtils.generatePropertyName(getSelfAlias(), "stage"), getStageAlias());
        } else if (this.pQC != null && !this.pQC.isEmpty()) {
            this.pQC.setSelfAlias(this.getProjectAlias());
            criteria.createAlias(QCUtils.generatePropertyName(getStageAlias(), "project"), getProjectAlias());
            this.pQC.setAlias(criteria);
        }
    }

    public String getStageAlias() {
        return stageAlias;
    }

    public void setStageAlias(String stageAlias) {
        this.stageAlias = stageAlias;
    }

    public String getProjectAlias() {
        return projectAlias;
    }

    public void setProjectAlias(String projectAlias) {
        this.projectAlias = projectAlias;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public ProjectQueryCondition getpQC() {
        return pQC;
    }

    public void setpQC(ProjectQueryCondition pQC) {
        this.pQC = pQC;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public Boolean getReadyHouse() {
        return readyHouse;
    }

    public void setReadyHouse(Boolean readyHouse) {
        this.readyHouse = readyHouse;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

}
