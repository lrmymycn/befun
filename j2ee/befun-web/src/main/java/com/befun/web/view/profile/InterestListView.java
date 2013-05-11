package com.befun.web.view.profile;

import java.util.List;

import com.befun.domain.profile.InterestList;

public class InterestListView extends BaseProfileView<InterestList> {

    private static final long serialVersionUID = 607541607242583262L;

    private String name;

    private String description;

    private List<ApartmentInterestListItemView> apartments;

    private List<FloorplanInterestListItemView> floorplans;

    public InterestListView() {
        super();
    }

    public InterestListView(InterestList model) {
        super(model);
    }

    @Override
    public InterestList getModel() {
        return this.model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ApartmentInterestListItemView> getApartments() {
        return apartments;
    }

    public void setApartments(List<ApartmentInterestListItemView> apartments) {
        this.apartments = apartments;
    }

    public List<FloorplanInterestListItemView> getFloorplans() {
        return floorplans;
    }

    public void setFloorplans(List<FloorplanInterestListItemView> floorplans) {
        this.floorplans = floorplans;
    }

}
