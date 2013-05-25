package com.befun.web.view.profile;

import com.befun.domain.estate.FloorplanType;
import com.befun.domain.profile.ClientRequirement;

public class ClientRequirementView extends BaseProfileView<ClientRequirement> {

    private static final long serialVersionUID = -1565514235359290281L;

    private Long clientId;

    private Integer minPrice;

    private Integer maxPrice;

    private Boolean pentHouse;

    private FloorplanType[] floorplanTypes;

    private Double minTotalSize;

    private Double maxTotalSize;

    private String[] bedRoomCounts;

    private String[] bathRoomCounts;

    private String[] courtyardCounts;

    private String[] enclosedBaclonyCounts;

    private String[] studyroomCounts;

    private String[] carParkingCounts;

    private String[] storageRoomCounts;

    private Boolean split;

    private Boolean studio;

    private String[] orientations;

    private Boolean readyHouse;

    private Long suburbId;

    private Double distanceToCity;

    private Boolean universities;

    private Boolean schools;

    private Boolean shoppingCenter;

    private Boolean train;

    private Boolean chineseCommunity;

    private String description;

    public ClientRequirementView() {
        super();
    }

    public ClientRequirementView(ClientRequirement model) {
        super(model);
    }

    @Override
    public ClientRequirement getModel() {
        return this.model;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public FloorplanType[] getFloorplanTypes() {
        return floorplanTypes;
    }

    public void setFloorplanTypes(FloorplanType[] floorplanTypes) {
        this.floorplanTypes = floorplanTypes;
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

    public String[] getBedRoomCounts() {
        return bedRoomCounts;
    }

    public void setBedRoomCounts(String[] bedRoomCounts) {
        this.bedRoomCounts = bedRoomCounts;
    }

    public String[] getBathRoomCounts() {
        return bathRoomCounts;
    }

    public void setBathRoomCounts(String[] bathRoomCounts) {
        this.bathRoomCounts = bathRoomCounts;
    }

    public String[] getCourtyardCounts() {
        return courtyardCounts;
    }

    public void setCourtyardCounts(String[] courtyardCounts) {
        this.courtyardCounts = courtyardCounts;
    }

    public String[] getEnclosedBaclonyCounts() {
        return enclosedBaclonyCounts;
    }

    public void setEnclosedBaclonyCounts(String[] enclosedBaclonyCounts) {
        this.enclosedBaclonyCounts = enclosedBaclonyCounts;
    }

    public String[] getStudyroomCounts() {
        return studyroomCounts;
    }

    public void setStudyroomCounts(String[] studyroomCounts) {
        this.studyroomCounts = studyroomCounts;
    }

    public String[] getCarParkingCounts() {
        return carParkingCounts;
    }

    public void setCarParkingCounts(String[] carParkingCounts) {
        this.carParkingCounts = carParkingCounts;
    }

    public String[] getStorageRoomCounts() {
        return storageRoomCounts;
    }

    public void setStorageRoomCounts(String[] storageRoomCounts) {
        this.storageRoomCounts = storageRoomCounts;
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

    public String[] getOrientations() {
        return orientations;
    }

    public void setOrientations(String[] orientations) {
        this.orientations = orientations;
    }

    public Boolean getReadyHouse() {
        return readyHouse;
    }

    public void setReadyHouse(Boolean readyHouse) {
        this.readyHouse = readyHouse;
    }

    public Long getSuburbId() {
        return suburbId;
    }

    public void setSuburbId(Long suburbId) {
        this.suburbId = suburbId;
    }

    public Double getDistanceToCity() {
        return distanceToCity;
    }

    public void setDistanceToCity(Double distanceToCity) {
        this.distanceToCity = distanceToCity;
    }

    public Boolean getUniversities() {
        return universities;
    }

    public void setUniversities(Boolean universities) {
        this.universities = universities;
    }

    public Boolean getSchools() {
        return schools;
    }

    public void setSchools(Boolean schools) {
        this.schools = schools;
    }

    public Boolean getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(Boolean shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }

    public Boolean getTrain() {
        return train;
    }

    public void setTrain(Boolean train) {
        this.train = train;
    }

    public Boolean getChineseCommunity() {
        return chineseCommunity;
    }

    public void setChineseCommunity(Boolean chineseCommunity) {
        this.chineseCommunity = chineseCommunity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
