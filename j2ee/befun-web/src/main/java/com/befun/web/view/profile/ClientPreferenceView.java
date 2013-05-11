package com.befun.web.view.profile;

import com.befun.domain.profile.ClientPreference;

public class ClientPreferenceView extends BaseProfileView<ClientPreference> {

    private static final long serialVersionUID = -3560065063561810134L;

    private String floorplanType;

    private String area;

    private String distanceToCity;

    private String bedroom;

    private String bathroom;

    private String studyroom;

    private String priceRange;

    private String readyHouse;

    private String trains;

    private String shoppingCentres;

    private String schools;

    private String waterView;

    private String cityView;

    private String highQualityFinish;

    private String luxury;

    private String goodLiveEnv;

    private String description;

    public ClientPreferenceView() {
        super();
    }

    public ClientPreferenceView(ClientPreference model) {
        super(model);
    }

    @Override
    public ClientPreference getModel() {
        return this.model;
    }

    public String getFloorplanType() {
        return floorplanType;
    }

    public void setFloorplanType(String floorplanType) {
        this.floorplanType = floorplanType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDistanceToCity() {
        return distanceToCity;
    }

    public void setDistanceToCity(String distanceToCity) {
        this.distanceToCity = distanceToCity;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public String getStudyroom() {
        return studyroom;
    }

    public void setStudyroom(String studyroom) {
        this.studyroom = studyroom;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getReadyHouse() {
        return readyHouse;
    }

    public void setReadyHouse(String readyHouse) {
        this.readyHouse = readyHouse;
    }

    public String getTrains() {
        return trains;
    }

    public void setTrains(String trains) {
        this.trains = trains;
    }

    public String getShoppingCentres() {
        return shoppingCentres;
    }

    public void setShoppingCentres(String shoppingCentres) {
        this.shoppingCentres = shoppingCentres;
    }

    public String getSchools() {
        return schools;
    }

    public void setSchools(String schools) {
        this.schools = schools;
    }

    public String getWaterView() {
        return waterView;
    }

    public void setWaterView(String waterView) {
        this.waterView = waterView;
    }

    public String getCityView() {
        return cityView;
    }

    public void setCityView(String cityView) {
        this.cityView = cityView;
    }

    public String getHighQualityFinish() {
        return highQualityFinish;
    }

    public void setHighQualityFinish(String highQualityFinish) {
        this.highQualityFinish = highQualityFinish;
    }

    public String getLuxury() {
        return luxury;
    }

    public void setLuxury(String luxury) {
        this.luxury = luxury;
    }

    public String getGoodLiveEnv() {
        return goodLiveEnv;
    }

    public void setGoodLiveEnv(String goodLiveEnv) {
        this.goodLiveEnv = goodLiveEnv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
