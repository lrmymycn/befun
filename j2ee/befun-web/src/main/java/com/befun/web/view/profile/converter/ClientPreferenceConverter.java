package com.befun.web.view.profile.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.profile.ClientPreference;
import com.befun.web.view.profile.ClientPreferenceView;

public class ClientPreferenceConverter extends AbstractProfileViewConverter<ClientPreference, ClientPreferenceView> {

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
    public void convertToView(ClientPreference model, ClientPreferenceView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
    }

    @Override
    public void convertToModel(ClientPreferenceView view, ClientPreference model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
    }

    @Override
    public ClientPreference generateModel(Object params) {
        return new ClientPreference();
    }

    @Override
    public ClientPreferenceView generateView(ClientPreference model, Object params) {
        return new ClientPreferenceView(model);
    }

}
