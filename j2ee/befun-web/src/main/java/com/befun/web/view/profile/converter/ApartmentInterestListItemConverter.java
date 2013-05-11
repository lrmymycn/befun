package com.befun.web.view.profile.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.profile.ApartmentInterestListItem;
import com.befun.web.view.profile.ApartmentInterestListItemView;

public class ApartmentInterestListItemConverter extends AbstractProfileViewConverter<ApartmentInterestListItem, ApartmentInterestListItemView> {

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
    public void convertToView(ApartmentInterestListItem model, ApartmentInterestListItemView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
    }

    @Override
    public void convertToModel(ApartmentInterestListItemView view, ApartmentInterestListItem model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
    }

    @Override
    public ApartmentInterestListItem generateModel(Object params) {
        return new ApartmentInterestListItem();
    }

    @Override
    public ApartmentInterestListItemView generateView(ApartmentInterestListItem model, Object params) {
        return new ApartmentInterestListItemView(model);
    }

}
