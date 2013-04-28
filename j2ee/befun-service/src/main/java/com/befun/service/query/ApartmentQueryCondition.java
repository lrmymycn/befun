package com.befun.service.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class ApartmentQueryCondition extends EstateQueryCondition {

    private static final long serialVersionUID = 5014083200574685524L;

    private String floorplanAlias = QueryConstants.ALIAS_FLOORPLAN;

    private String buildingAlias = QueryConstants.ALIAS_BUILDING;

    private String stageAlias = QueryConstants.ALIAS_STAGE;

    private String projectAlias = QueryConstants.ALIAS_PROJECT;

    private Long floorplanId;

    private FloorplanQueryCondition fpQC;

    private Integer minPrice;

    private Integer maxPrice;

    private Boolean pentHouse;

    private Short minCarParkingCount;

    private Short maxCarParkingCount;

    private Short minStorageRoomCount;

    private Short maxStorageRoomCount;

    public ApartmentQueryCondition() {
        super();
    }

    public ApartmentQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public ApartmentQueryCondition(String selfAlias, String floorplanAlias, String buildingAlias, String stageAlias, String projectAlias) {
        super(selfAlias);
        this.floorplanAlias = floorplanAlias;
        this.buildingAlias = buildingAlias;
        this.stageAlias = stageAlias;
        this.projectAlias = projectAlias;
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.floorplanId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "floorplan.id"), this.floorplanId);
            rs.add(tmp);
        } else {
            if (this.fpQC != null && !this.fpQC.isEmpty()) {
                rs.addAll(this.fpQC.getCriterions());
            }
        }
        if (this.pentHouse != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "pentHouse"), this.pentHouse);
            rs.add(tmp);
        }
        if (this.minCarParkingCount != null) {
            tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "carParkingCount"), this.minCarParkingCount);
            rs.add(tmp);
        }
        if (this.maxCarParkingCount != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "carParkingCount"), this.maxCarParkingCount);
            rs.add(tmp);
        }
        if (this.minStorageRoomCount != null) {
            tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "storageRoomCount"), this.minStorageRoomCount);
            rs.add(tmp);
        }
        if (this.maxStorageRoomCount != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "storageRoomCount"), this.maxStorageRoomCount);
            rs.add(tmp);
        }
        if (this.minPrice != null) {
            tmp = Restrictions.gt(QCUtils.generatePropertyName(this.getSelfAlias(), "price"), this.minPrice);
            rs.add(tmp);
        }
        if (this.maxPrice != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "price"), this.maxPrice);
            rs.add(tmp);
        }
        return rs;
    }

    @Override
    public void setAlias(Criteria criteria) {
        if (this.floorplanId == null && (this.fpQC != null && !this.fpQC.isEmpty())) {
            this.fpQC.setSelfAlias(this.getFloorplanAlias());
            this.fpQC.setBuildingAlias(this.getBuildingAlias());
            this.fpQC.setStageAlias(this.getStageAlias());
            this.fpQC.setProjectAlias(this.getProjectAlias());
            criteria.createAlias(QCUtils.generatePropertyName(getSelfAlias(), "floorplan"), this.getFloorplanAlias());
            this.fpQC.setAlias(criteria);
        }
    }

    @Override
    public void setAlias(DetachedCriteria criteria) {
        criteria.createAlias(QCUtils.generatePropertyName(getSelfAlias(), "floorplan"), this.getFloorplanAlias());
        criteria.createAlias(QCUtils.generatePropertyName(getFloorplanAlias(), "building"), this.getBuildingAlias());
        criteria.createAlias(QCUtils.generatePropertyName(getBuildingAlias(), "stage"), this.getStageAlias());
        if (this.floorplanId == null && (this.fpQC != null && !this.fpQC.isEmpty())) {
            this.fpQC.setSelfAlias(this.getFloorplanAlias());
            this.fpQC.setBuildingAlias(this.getBuildingAlias());
            this.fpQC.setStageAlias(this.getStageAlias());
            this.fpQC.setProjectAlias(this.getProjectAlias());
            this.fpQC.setAlias(criteria);
        }
    }

    public String getFloorplanAlias() {
        return floorplanAlias;
    }

    public void setFloorplanAlias(String floorplanAlias) {
        this.floorplanAlias = floorplanAlias;
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

    public Long getFloorplanId() {
        return floorplanId;
    }

    public void setFloorplanId(Long floorplanId) {
        this.floorplanId = floorplanId;
    }

    public FloorplanQueryCondition getFpQC() {
        return fpQC;
    }

    public void setFpQC(FloorplanQueryCondition fpQC) {
        this.fpQC = fpQC;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Boolean getPentHouse() {
        return pentHouse;
    }

    public void setPentHouse(Boolean pentHouse) {
        this.pentHouse = pentHouse;
    }

    public Short getMinCarParkingCount() {
        return minCarParkingCount;
    }

    public void setMinCarParkingCount(Short minCarParkingCount) {
        this.minCarParkingCount = minCarParkingCount;
    }

    public Short getMaxCarParkingCount() {
        return maxCarParkingCount;
    }

    public void setMaxCarParkingCount(Short maxCarParkingCount) {
        this.maxCarParkingCount = maxCarParkingCount;
    }

    public Short getMinStorageRoomCount() {
        return minStorageRoomCount;
    }

    public void setMinStorageRoomCount(Short minStorageRoomCount) {
        this.minStorageRoomCount = minStorageRoomCount;
    }

    public Short getMaxStorageRoomCount() {
        return maxStorageRoomCount;
    }

    public void setMaxStorageRoomCount(Short maxStorageRoomCount) {
        this.maxStorageRoomCount = maxStorageRoomCount;
    }

}
