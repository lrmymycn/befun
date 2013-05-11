package com.befun.web.view.profile;

import com.befun.domain.profile.FloorplanInterestListItem;
import com.befun.web.view.FloorplanView;

public class FloorplanInterestListItemView extends BaseProfileView<FloorplanInterestListItem> {

    private static final long serialVersionUID = 607541607242583262L;

    private FloorplanView apartment;

    private String description;

    public FloorplanInterestListItemView() {
        super();
    }

    public FloorplanInterestListItemView(FloorplanInterestListItem model) {
        super(model);
    }

    @Override
    public FloorplanInterestListItem getModel() {
        return this.model;
    }

    public FloorplanView getFloorplan() {
        return apartment;
    }

    public void setFloorplan(FloorplanView apartment) {
        this.apartment = apartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
