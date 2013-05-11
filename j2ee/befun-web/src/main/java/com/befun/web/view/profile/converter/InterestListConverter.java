package com.befun.web.view.profile.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.profile.InterestList;
import com.befun.web.view.profile.InterestListView;

public class InterestListConverter extends AbstractProfileViewConverter<InterestList, InterestListView> {

    public final static String[] IGNORED_PROPS_MODEL_VIEW = new String[] { "apartments", "floorplans" };

    public final static String[] IGNORED_PROPS_VIEW_MODEL = new String[] { "apartments", "floorplans" };

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_MODEL_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_MODEL;
    }

    @Override
    public void convertToView(InterestList model, InterestListView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
    }

    @Override
    public void convertToModel(InterestListView view, InterestList model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
    }

    @Override
    public InterestList generateModel(Object params) {
        return new InterestList();
    }

    @Override
    public InterestListView generateView(InterestList model, Object params) {
        return new InterestListView(model);
    }

}
