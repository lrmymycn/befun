package com.befun.web.view.profile.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.profile.Client;
import com.befun.web.view.profile.ClientView;

public class ClientConverter extends AbstractProfileViewConverter<Client, ClientView> {

    public final static String[] IGNORED_PROPS_MODEL_VIEW = new String[] { "currentEmployee", "preference" };

    public final static String[] IGNORED_PROPS_VIEW_MODEL = new String[] { "currentEmployee", "preference" };

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_MODEL_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_MODEL;
    }

    @Override
    public void convertToView(Client model, ClientView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
    }

    @Override
    public void convertToModel(ClientView view, Client model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
    }

    @Override
    public Client generateModel(Object params) {
        return new Client();
    }

    @Override
    public ClientView generateView(Client model, Object params) {
        return new ClientView(model);
    }

}
