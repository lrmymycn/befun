package com.befun.web.view;

import java.util.Date;

import com.befun.domain.estate.Building;

public class BuildingView extends BaseView<Building> {

    private static final long serialVersionUID = 4757553952765339386L;

    private Long stageId;

    //
    private String buildingNumber;

    private String description;

    private Date finishDate;

    private Short floorCount;

    private Short orientation;

    private boolean readyHouse;

    private Integer sold;

    private boolean soldOut;

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

    public Short getOrientation() {
        return orientation;
    }

    public void setOrientation(Short orientation) {
        this.orientation = orientation;
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
