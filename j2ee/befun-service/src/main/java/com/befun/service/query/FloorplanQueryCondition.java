package com.befun.service.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.befun.domain.estate.FloorplanType;

public class FloorplanQueryCondition extends EstateQueryCondition {

    private static final long serialVersionUID = -4072027687684889104L;

    private String buildingAlias = QueryConstants.ALIAS_BUILDING;

    private String stageAlias = QueryConstants.ALIAS_STAGE;

    private String projectAlias = QueryConstants.ALIAS_PROJECT;

    private Long buildingId;

    private BuildingQueryCondition bQC;

    private FloorplanType floorplanType;

    // >
    private Double minTotalSize;

    // <=
    private Double maxTotalSize;

    private String bedRoomCountStr;

    private Short minBedRoomCount;

    private Short maxBedRoomCount;

    private String bathRoomCountStr;

    private Short minBathRoomCount;

    private Short maxBathRoomCount;

    private String courtyardCountStr;

    private String enclosedBaclonyCountStr;

    private String studyroomCountStr;

    private Boolean split;

    private Boolean studio;

    private Boolean orientationEast;

    private Boolean orientationSouth;

    private Boolean orientationWest;

    private Boolean orientationNorth;

    public FloorplanQueryCondition() {
        super();
        this.setSelfAlias(QueryConstants.ALIAS_FLOORPLAN);
    }

    public FloorplanQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public FloorplanQueryCondition(String selfAlias, String buildingAlias, String stageAlias, String projectAlias) {
        super(selfAlias);
        this.buildingAlias = buildingAlias;
        this.stageAlias = stageAlias;
        this.projectAlias = projectAlias;
    }

    @Override
    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.buildingId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "building.id"), this.buildingId);
            rs.add(tmp);
        } else if (this.bQC != null && !this.bQC.isEmpty()) {
            rs.addAll(this.bQC.getCriterions());
        }

        if (this.floorplanType != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "type"), this.floorplanType);
            rs.add(tmp);
        }
        if (this.minTotalSize != null) {
            tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "totalSize"), this.minTotalSize);
            rs.add(tmp);
        }
        if (this.maxTotalSize != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "totalSize"), this.maxTotalSize);
            rs.add(tmp);
        }
        Criterion bedRoomCounts = QCUtils.parseCounts(QCUtils.generatePropertyName(this.getSelfAlias(), "bedRoomCount"), this.bedRoomCountStr);
        if (bedRoomCounts != null) {
            rs.add(bedRoomCounts);
        }
        Criterion bathRoomCounts = QCUtils.parseCounts(QCUtils.generatePropertyName(this.getSelfAlias(), "bathroomCount"), this.bathRoomCountStr);
        if (bedRoomCounts != null) {
            rs.add(bathRoomCounts);
        }
        /*
         * if (this.minBedRoomCount != null) {
         * tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "bedRoomCount"), this.minBedRoomCount);
         * rs.add(tmp);
         * }
         * if (this.maxBedRoomCount != null) {
         * tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "bedRoomCount"), this.maxBedRoomCount);
         * rs.add(tmp);
         * }
         * if (this.minBathRoomCount != null) {
         * tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "bathroomCount"), this.minBathRoomCount);
         * rs.add(tmp);
         * }
         * if (this.maxBathRoomCount != null) {
         * tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "bathroomCount"), this.maxBathRoomCount);
         * rs.add(tmp);
         * }
         */
        Criterion courtyardCounts = QCUtils.parseCounts(QCUtils.generatePropertyName(this.getSelfAlias(), "courtyardCount"), this.courtyardCountStr);
        if (courtyardCounts != null) {
            rs.add(courtyardCounts);
        }
        Criterion enclosedBaclonyCounts = QCUtils.parseCounts(QCUtils.generatePropertyName(this.getSelfAlias(), "enclosedBaclonyCount"),
                                                              this.enclosedBaclonyCountStr);
        if (enclosedBaclonyCounts != null) {
            rs.add(enclosedBaclonyCounts);
        }
        Criterion studyroomCounts = QCUtils.parseCounts(QCUtils.generatePropertyName(this.getSelfAlias(), "studyroomCount"), this.studyroomCountStr);
        if (studyroomCounts != null) {
            rs.add(studyroomCounts);
        }
        if (this.split != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "split"), this.split);
            rs.add(tmp);
        }
        if (this.studio != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "studio"), this.studio);
            rs.add(tmp);
        }
        if (this.orientationEast != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "orientationEast"), this.orientationEast);
            rs.add(tmp);
        }
        if (this.orientationSouth != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "orientationSouth"), this.orientationSouth);
            rs.add(tmp);
        }
        if (this.orientationWest != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "orientationWest"), this.orientationWest);
            rs.add(tmp);
        }
        if (this.orientationNorth != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "orientationNorth"), this.orientationNorth);
            rs.add(tmp);
        }
        return rs;
    }

    @Override
    public void setAlias(Criteria criteria) {
        if (this.buildingId == null && (this.bQC != null && !this.bQC.isEmpty())) {
            bQC.setSelfAlias(this.getBuildingAlias());
            bQC.setStageAlias(this.getStageAlias());
            bQC.setProjectAlias(this.getProjectAlias());
            criteria.createAlias(QCUtils.generatePropertyName(getSelfAlias(), "building"), this.getBuildingAlias());
            this.bQC.setAlias(criteria);
        }
    }

    @Override
    public void setAlias(DetachedCriteria criteria) {
        if (this.buildingId == null && (this.bQC != null && !this.bQC.isEmpty())) {
            bQC.setSelfAlias(this.getBuildingAlias());
            bQC.setStageAlias(this.getStageAlias());
            bQC.setProjectAlias(this.getProjectAlias());
            this.bQC.setAlias(criteria);
        }
    }

    public String getBuildingAlias() {
        return buildingAlias;
    }

    public void setBuildingAlias(String buildingAlias) {
        this.buildingAlias = buildingAlias;
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

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public BuildingQueryCondition getBQC() {
        return bQC;
    }

    public void setBQC(BuildingQueryCondition bQC) {
        this.bQC = bQC;
    }

    public FloorplanType getFloorplanType() {
        return floorplanType;
    }

    public void setFloorplanType(FloorplanType floorplanType) {
        this.floorplanType = floorplanType;
    }

    public Double getMinTotalSize() {
        return minTotalSize;
    }

    public void setMinTotalSize(Double minTotalSize) {
        this.minTotalSize = minTotalSize;
    }

    public Double getMaxTotalSize() {
        return maxTotalSize;
    }

    public void setMaxTotalSize(Double maxTotalSize) {
        this.maxTotalSize = maxTotalSize;
    }

    public Short getMinBedRoomCount() {
        return minBedRoomCount;
    }

    public void setMinBedRoomCount(Short minBedRoomCount) {
        this.minBedRoomCount = minBedRoomCount;
    }

    public Short getMaxBedRoomCount() {
        return maxBedRoomCount;
    }

    public void setMaxBedRoomCount(Short maxBedRoomCount) {
        this.maxBedRoomCount = maxBedRoomCount;
    }

    public Short getMinBathRoomCount() {
        return minBathRoomCount;
    }

    public void setMinBathRoomCount(Short minBathRoomCount) {
        this.minBathRoomCount = minBathRoomCount;
    }

    public Short getMaxBathRoomCount() {
        return maxBathRoomCount;
    }

    public void setMaxBathRoomCount(Short maxBathRoomCount) {
        this.maxBathRoomCount = maxBathRoomCount;
    }

    public Boolean getSplit() {
        return split;
    }

    public void setSplit(Boolean split) {
        this.split = split;
    }

    public Boolean getStudio() {
        return studio;
    }

    public void setStudio(Boolean studio) {
        this.studio = studio;
    }

    public String getBedRoomCountStr() {
        return bedRoomCountStr;
    }

    public void setBedRoomCountStr(String bedRoomCountStr) {
        this.bedRoomCountStr = bedRoomCountStr;
    }

    public String getBathRoomCountStr() {
        return bathRoomCountStr;
    }

    public void setBathRoomCountStr(String bathRoomCountStr) {
        this.bathRoomCountStr = bathRoomCountStr;
    }

    public String getCourtyardCountStr() {
        return courtyardCountStr;
    }

    public void setCourtyardCountStr(String courtyardCountStr) {
        this.courtyardCountStr = courtyardCountStr;
    }

    public String getEnclosedBaclonyCountStr() {
        return enclosedBaclonyCountStr;
    }

    public void setEnclosedBaclonyCountStr(String enclosedBaclonyCountStr) {
        this.enclosedBaclonyCountStr = enclosedBaclonyCountStr;
    }

    public String getStudyroomCountStr() {
        return studyroomCountStr;
    }

    public void setStudyroomCountStr(String studyroomCountStr) {
        this.studyroomCountStr = studyroomCountStr;
    }

    public Boolean getOrientationEast() {
        return orientationEast;
    }

    public void setOrientationEast(Boolean orientationEast) {
        this.orientationEast = orientationEast;
    }

    public Boolean getOrientationSouth() {
        return orientationSouth;
    }

    public void setOrientationSouth(Boolean orientationSouth) {
        this.orientationSouth = orientationSouth;
    }

    public Boolean getOrientationWest() {
        return orientationWest;
    }

    public void setOrientationWest(Boolean orientationWest) {
        this.orientationWest = orientationWest;
    }

    public Boolean getOrientationNorth() {
        return orientationNorth;
    }

    public void setOrientationNorth(Boolean orientationNorth) {
        this.orientationNorth = orientationNorth;
    }

}
