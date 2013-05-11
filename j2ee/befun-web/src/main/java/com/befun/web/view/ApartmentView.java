package com.befun.web.view;

import com.befun.domain.estate.Apartment;

public class ApartmentView extends BaseEasteView<Apartment> {

    private static final long serialVersionUID = -1484346576753677173L;

    private String projectName;

    private String stageName;

    private String buildingNum;

    private String floorplanName;

    private Long floorplanId;

    //
    private String description;

    private String unitNumber;

    private String lotNumber;

    private Short floorLevel;

    private boolean pentHouse;

    private Integer price;

    private Integer avgPricePerSQM;

    private Short unitEntitlement;

    private String colorScheme;

    private Short carParkingCount;

    private Short storageRoomCount;

    private boolean soldOut;

    public ApartmentView() {
        super();
    }

    public ApartmentView(Apartment model) {
        super(model);
    }

    @Override
    public Apartment getModel() {
        return this.model;
    }

    //

    public Long getFloorplanId() {
        return floorplanId;
    }

    public void setFloorplanId(Long floorplanId) {
        this.floorplanId = floorplanId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Short getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(Short floorLevel) {
        this.floorLevel = floorLevel;
    }

    public boolean isPentHouse() {
        return pentHouse;
    }

    public void setPentHouse(boolean pentHouse) {
        this.pentHouse = pentHouse;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Short getUnitEntitlement() {
        return unitEntitlement;
    }

    public void setUnitEntitlement(Short unitEntitlement) {
        this.unitEntitlement = unitEntitlement;
    }

    public String getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(String colorScheme) {
        this.colorScheme = colorScheme;
    }

    public Short getCarParkingCount() {
        return carParkingCount;
    }

    public void setCarParkingCount(Short carParkingCount) {
        this.carParkingCount = carParkingCount;
    }

    public Short getStorageRoomCount() {
        return storageRoomCount;
    }

    public void setStorageRoomCount(Short storageRoomCount) {
        this.storageRoomCount = storageRoomCount;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getFloorplanName() {
        return floorplanName;
    }

    public void setFloorplanName(String floorplanName) {
        this.floorplanName = floorplanName;
    }

    public Integer getAvgPricePerSQM() {
        return avgPricePerSQM;
    }

    public void setAvgPricePerSQM(Integer avgPricePerSQM) {
        this.avgPricePerSQM = avgPricePerSQM;
    }

    @Override
    public String toString() {
        return "ApartmentView [projectName=" + projectName + ", stateName=" + stageName + ", buildingNum=" + buildingNum + ", floorplanName=" + floorplanName
               + ", floorplanId=" + floorplanId + ", description=" + description + ", unitNumber=" + unitNumber + ", lotNumber=" + lotNumber + ", floorLevel="
               + floorLevel + ", pentHouse=" + pentHouse + ", price=" + price + ", unitEntitlement=" + unitEntitlement + ", colorScheme=" + colorScheme
               + ", carParkingCount=" + carParkingCount + ", storageRoomCount=" + storageRoomCount + ", soldOut=" + soldOut + ", toString()="
               + super.toString() + "]";
    }

}
