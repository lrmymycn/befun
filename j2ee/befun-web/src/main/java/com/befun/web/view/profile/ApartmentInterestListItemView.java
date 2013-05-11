package com.befun.web.view.profile;

import com.befun.domain.profile.ApartmentInterestListItem;
import com.befun.web.view.ApartmentView;

public class ApartmentInterestListItemView extends BaseProfileView<ApartmentInterestListItem> {

    private static final long serialVersionUID = 607541607242583262L;

    private ApartmentView apartment;

    private String description;

    public ApartmentInterestListItemView() {
        super();
    }

    public ApartmentInterestListItemView(ApartmentInterestListItem model) {
        super(model);
    }

    @Override
    public ApartmentInterestListItem getModel() {
        return this.model;
    }

    public ApartmentView getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentView apartment) {
        this.apartment = apartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
