package com.befun.service.query.estate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.befun.domain.estate.FloorplanType;
import com.befun.service.query.QCUtils;
import com.befun.service.query.QueryConstants;

public class FloorplanQueryCondition extends EstateQueryCondition {

    private static final long serialVersionUID = -4072027687684889104L;

    private String buildingAlias = QueryConstants.ALIAS_BUILDING;

    private String stageAlias = QueryConstants.ALIAS_STAGE;

    private String projectAlias = QueryConstants.ALIAS_PROJECT;

    private String suburbAlias = QueryConstants.ALIAS_SUBURB;

    private Long buildingId;

    private BuildingQueryCondition bdQC = new BuildingQueryCondition();

    private String floorplanTypeStr;

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

    private String orientationStr;

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
        } else if (this.bdQC != null && !this.bdQC.isEmpty()) {
            rs.addAll(this.bdQC.getCriterions());
        }

        if (this.floorplanType != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "type"), this.floorplanType);
            rs.add(tmp);
        } else {
            Criterion floorplanTypes = QCUtils.parseFloorplanTypesCriterion(QCUtils.generatePropertyName(this.getSelfAlias(), "type"), this.floorplanTypeStr);
            if (floorplanTypes != null) {
                rs.add(floorplanTypes);
            }
        }
        if (this.minTotalSize != null) {
            tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "totalSize"), this.minTotalSize);
            rs.add(tmp);
        }
        if (this.maxTotalSize != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "totalSize"), this.maxTotalSize);
            rs.add(tmp);
        }
        Criterion bedRoomCounts = QCUtils.parseCountsCriterion(QCUtils.generatePropertyName(this.getSelfAlias(), "bedRoomCount"), this.bedRoomCountStr);
        if (bedRoomCounts != null) {
            rs.add(bedRoomCounts);
        }
        Criterion bathRoomCounts = QCUtils.parseCountsCriterion(QCUtils.generatePropertyName(this.getSelfAlias(), "bathroomCount"), this.bathRoomCountStr);
        if (bathRoomCounts != null) {
            rs.add(bathRoomCounts);
        }
        Criterion courtyardCounts = QCUtils.parseCountsCriterion(QCUtils.generatePropertyName(this.getSelfAlias(), "courtyardCount"), this.courtyardCountStr);
        if (courtyardCounts != null) {
            rs.add(courtyardCounts);
        }
        Criterion enclosedBaclonyCounts = QCUtils.parseCountsCriterion(QCUtils.generatePropertyName(this.getSelfAlias(), "enclosedBaclonyCount"),
                                                              this.enclosedBaclonyCountStr);
        if (enclosedBaclonyCounts != null) {
            rs.add(enclosedBaclonyCounts);
        }
        Criterion studyroomCounts = QCUtils.parseCountsCriterion(QCUtils.generatePropertyName(this.getSelfAlias(), "studyroomCount"), this.studyroomCountStr);
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
        if (this.orientationEast == null && this.orientationSouth == null && this.orientationWest == null && this.orientationNorth == null) {
            String eastProp = QCUtils.generatePropertyName(this.getSelfAlias(), "orientationEast");
            String southProp = QCUtils.generatePropertyName(this.getSelfAlias(), "orientationSouth");
            String westProp = QCUtils.generatePropertyName(this.getSelfAlias(), "orientationWest");
            String northProp = QCUtils.generatePropertyName(this.getSelfAlias(), "orientationNorth");

            Criterion orientations = QCUtils.parseOrientationsCriterion(orientationStr, eastProp, southProp, westProp, northProp);
            if (orientations != null) {
                rs.add(orientations);
            }
        }
        return rs;
    }

    @Override
    public void setAlias(Criteria criteria) {
        if (this.buildingId == null && (this.bdQC != null && !this.bdQC.isEmpty())) {
            bdQC.setSelfAlias(this.getBuildingAlias());
            bdQC.setStageAlias(this.getStageAlias());
            bdQC.setProjectAlias(this.getProjectAlias());
            bdQC.setSuburbAlias(this.getSuburbAlias());
            criteria.createAlias(QCUtils.generatePropertyName(getSelfAlias(), "building"), this.getBuildingAlias());
            this.bdQC.setAlias(criteria);
        }
    }

    @Override
    public void setAlias(DetachedCriteria criteria) {
        if (this.buildingId == null && (this.bdQC != null && !this.bdQC.isEmpty())) {
            bdQC.setSelfAlias(this.getBuildingAlias());
            bdQC.setStageAlias(this.getStageAlias());
            bdQC.setProjectAlias(this.getProjectAlias());
            bdQC.setSuburbAlias(this.getSuburbAlias());
            this.bdQC.setAlias(criteria);
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

    public String getSuburbAlias() {
        return suburbAlias;
    }

    public void setSuburbAlias(String suburbAlias) {
        this.suburbAlias = suburbAlias;
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

    public BuildingQueryCondition getBdQC() {
        return bdQC;
    }

    public void setBdQC(BuildingQueryCondition bdQC) {
        this.bdQC = bdQC;
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
