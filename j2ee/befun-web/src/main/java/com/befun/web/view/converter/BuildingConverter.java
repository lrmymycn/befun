package com.befun.web.view.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.estate.Building;
import com.befun.domain.estate.Stage;
import com.befun.web.view.BuildingView;

public class BuildingConverter extends AbstractViewConverter<Building, BuildingView> {

    public final static String[] IGNORED_PROPS_BUILDING_VIEW = new String[] {};

    public final static String[] IGNORED_PROPS_VIEW_BUILDING = new String[] {};

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_BUILDING_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_BUILDING;
    }

    @Override
    public void convertToView(Building model, BuildingView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
        view.setStageId(model.getStage().getId());
        copyModelModification(model.getModelModification(), view);
    }

    @Override
    public void convertToModel(BuildingView view, Building model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
        if (view.getStageId() != null) {
            Stage stage = new Stage();
            stage.setId(view.getStageId());
            model.setStage(stage);
        }
    }

    @Override
    public Building generateModel(Object params) {
        return new Building();
    }

    @Override
    public BuildingView generateView(Building model, Object params) {
        return new BuildingView(model);
    }

}
