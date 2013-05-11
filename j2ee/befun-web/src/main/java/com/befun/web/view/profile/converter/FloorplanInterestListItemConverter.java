package com.befun.web.view.profile.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.profile.FloorplanInterestListItem;
import com.befun.web.view.profile.FloorplanInterestListItemView;

public class FloorplanInterestListItemConverter extends AbstractProfileViewConverter<FloorplanInterestListItem, FloorplanInterestListItemView> {

    public final static String[] IGNORED_PROPS_MODEL_VIEW = new String[] {};

    public final static String[] IGNORED_PROPS_VIEW_MODEL = new String[] {};

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_MODEL_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_MODEL;
    }

    @Override
    public void convertToView(FloorplanInterestListItem model, FloorplanInterestListItemView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
    }

    @Override
    public void convertToModel(FloorplanInterestListItemView view, FloorplanInterestListItem model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
    }

    @Override
    public FloorplanInterestListItem generateModel(Object params) {
        return new FloorplanInterestListItem();
    }

    @Override
    public FloorplanInterestListItemView generateView(FloorplanInterestListItem model, Object params) {
        return new FloorplanInterestListItemView(model);
    }

}
