package com.befun.web.view.profile.converter;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.befun.domain.profile.ClientRequirement;
import com.befun.service.query.QCUtils;
import com.befun.web.view.profile.ClientRequirementView;

public class ClientRequirementConverter extends AbstractProfileViewConverter<ClientRequirement, ClientRequirementView> {

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
    public void convertToView(ClientRequirement model, ClientRequirementView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
        List<String> counts = QCUtils.parseCounts(model.getBathRoomCountStr());
    }

    @Override
    public void convertToModel(ClientRequirementView view, ClientRequirement model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
    }

    @Override
    public ClientRequirement generateModel(Object params) {
        return new ClientRequirement();
    }

    @Override
    public ClientRequirementView generateView(ClientRequirement model, Object params) {
        return new ClientRequirementView(model);
    }

}
