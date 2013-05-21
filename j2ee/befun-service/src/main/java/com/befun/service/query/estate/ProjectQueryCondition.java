package com.befun.service.query.estate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.befun.domain.estate.Apartment;
import com.befun.service.query.QCUtils;
import com.befun.service.query.QueryConstants;

public class ProjectQueryCondition extends EstateQueryCondition {

    private static final long serialVersionUID = 7048642797010394434L;

    private String suburbAlias = QueryConstants.ALIAS_SUBURB;

    private String apartmentAlias = "pro_ap";

    private boolean groupByArea = false;

    private boolean groupBySuburb = false;

    private Long suburbId;

    private SuburbQueryCondition suburbQC = new SuburbQueryCondition();

    private Double distanceToCity;

    private Double minLongitude;

    private Double maxLongitude;

    private Double minLatitude;

    private Double maxLatitude;

    private ApartmentQueryCondition apQC;

    public ProjectQueryCondition() {
        super();
        this.setSelfAlias(QueryConstants.ALIAS_PROJECT);
    }

    public ProjectQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public ProjectQueryCondition(String selfAlias, String suburbAlias) {
        super(selfAlias);
        this.suburbAlias = suburbAlias;
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.suburbId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(getSelfAlias(), "suburb.id"), this.suburbId);
            rs.add(tmp);
        } else if (this.suburbQC != null) {
            rs.addAll(this.suburbQC.getCriterions());
        }

        if (this.distanceToCity != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "distanceToCity"), this.distanceToCity);
            rs.add(tmp);
        }
        if (this.minLongitude != null) {
            tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "longitude"), this.minLongitude);
            rs.add(tmp);
        }
        if (this.maxLongitude != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "longitude"), this.maxLongitude);
            rs.add(tmp);
        }
        if (this.minLatitude != null) {
            tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "latitude"), this.minLatitude);
            rs.add(tmp);
        }
        if (this.maxLatitude != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "latitude"), this.maxLatitude);
            rs.add(tmp);
        }

        if (this.apQC != null && !this.apQC.isEmpty()) {
            DetachedCriteria dc = DetachedCriteria.forClass(Apartment.class, this.apQC.getSelfAlias());
            this.apQC.setAlias(dc);

            tmp = Restrictions.eqProperty(QCUtils.generatePropertyName(this.apQC.getStageAlias(), "project.id"),
                                          QCUtils.generatePropertyName(this.getSelfAlias(), "id"));
            dc.add(tmp);

            List<Criterion> cs = this.apQC.getCriterions();
            for (Criterion c : cs) {
                dc.add(c);
            }
            dc.setProjection(Projections.property(QCUtils.generatePropertyName(this.apQC.getSelfAlias(), "id")));
            tmp = Subqueries.exists(dc);
            rs.add(tmp);
        }

        return rs;
    }

    @Override
    protected void buildGroup(Criteria criteria) {
        ProjectionList projections = Projections.projectionList();
        if (this.getGroupProperties() != null && !this.getGroupProperties().isEmpty()) {
            for (String g : this.getGroupProperties()) {
                projections.add(Projections.groupProperty(g));
            }
        }
        if (this.groupBySuburb) {
            projections.add(Projections.groupProperty(QCUtils.generatePropertyName(this.getSelfAlias(), "suburb")));
        } else if (this.groupByArea) {
            projections.add(Projections.groupProperty(QCUtils.generatePropertyName(this.getSuburbAlias(), "area")));
        }

        if (projections.isGrouped()) {
            projections.add(Projections.rowCount());
            criteria.setProjection(projections);
        }
    }

    @Override
    public void setAlias(Criteria criteria) {
        if (this.suburbId == null) {
            if (this.suburbQC != null && !this.suburbQC.isEmpty()) {
                this.suburbQC.setSelfAlias(this.getSuburbAlias());
                criteria.createAlias(QCUtils.generatePropertyName(this.getSelfAlias(), "suburb"), this.getSuburbAlias());
            }
        }

        if (this.apQC != null && !this.apQC.isEmpty()) {
            this.apQC.setSelfAlias(this.apartmentAlias);
            this.apQC.setFloorplanAlias("pro_ap_fp");
            this.apQC.setBuildingAlias("pro_ap_b");
            this.apQC.setStageAlias("pro_ap_st");
            this.apQC.setProjectAlias("pro_ap_pro");
            this.apQC.setSuburbAlias("pro_ap_s");
        }
    }

    @Override
    public void setAlias(DetachedCriteria criteria) {
        if (this.suburbId == null) {
            if (this.suburbQC != null && !this.suburbQC.isEmpty()) {
                this.suburbQC.setSelfAlias(this.getSuburbAlias());
                criteria.createAlias(QCUtils.generatePropertyName(this.getSelfAlias(), "suburb"), this.getSuburbAlias());
            }
        }
    }
    
    public String getSuburbAlias() {
        return suburbAlias;
    }

    public void setSuburbAlias(String suburbAlias) {
        this.suburbAlias = suburbAlias;
    }

    public boolean isGroupByArea() {
        return groupByArea;
    }

    public void setGroupByArea(boolean groupByArea) {
        this.groupByArea = groupByArea;
    }

    public boolean isGroupBySuburb() {
        return groupBySuburb;
    }

    public void setGroupBySuburb(boolean groupBySuburb) {
        this.groupBySuburb = groupBySuburb;
    }

    public Long getSuburbId() {
        return suburbId;
    }

    public void setSuburbId(Long suburbId) {
        this.suburbId = suburbId;
    }

    public SuburbQueryCondition getSuburbQC() {
        return suburbQC;
    }

    public void setSuburbQC(SuburbQueryCondition suburbQC) {
        this.suburbQC = suburbQC;
    }

    public Double getDistanceToCity() {
        return distanceToCity;
    }

    public void setDistanceToCity(Double distanceToCity) {
        this.distanceToCity = distanceToCity;
    }

    public Double getMinLongitude() {
        return minLongitude;
    }

    public void setMinLongitude(Double minLongitude) {
        this.minLongitude = minLongitude;
    }

    public Double getMaxLongitude() {
        return maxLongitude;
    }

    public void setMaxLongitude(Double maxLongitude) {
        this.maxLongitude = maxLongitude;
    }

    public Double getMinLatitude() {
        return minLatitude;
    }

    public void setMinLatitude(Double minLatitude) {
        this.minLatitude = minLatitude;
    }

    public Double getMaxLatitude() {
        return maxLatitude;
    }

    public void setMaxLatitude(Double maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public ApartmentQueryCondition getApQC() {
        return apQC;
    }

    public void setApQC(ApartmentQueryCondition apQC) {
        this.apQC = apQC;
    }

}
