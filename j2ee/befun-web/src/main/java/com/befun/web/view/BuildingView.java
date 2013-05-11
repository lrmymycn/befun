package com.befun.web.view;

import java.util.Date;

import com.befun.domain.estate.Building;

public class BuildingView extends BaseEasteView<Building> {

    private static final long serialVersionUID = 4757553952765339386L;

    private Long stageId;

    //
    private String buildingNumber;

    private String description;

    private Date finishDate;

    private Short floorCount;

    private Boolean orientationEast;

    private Boolean orientationSouth;

    private Boolean orientationWest;

    private Boolean orientationNorth;

    private boolean readyHouse;

    private Integer sold;

    private boolean soldOut;

    public BuildingView() {
        super();
    }

    public BuildingView(Building model) {
        super(model);
    }

    @Override
    public Building getModel() {
        return this.model;
    }

    //

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Short getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Short floorCount) {
        this.floorCount = floorCount;
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

    public boolean isReadyHouse() {
        return readyHouse;
    }

    public void setReadyHouse(boolean readyHouse) {
        this.readyHouse = readyHouse;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

}
