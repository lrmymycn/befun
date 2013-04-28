package com.befun.web.view.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.estate.Project;
import com.befun.domain.estate.Stage;
import com.befun.web.view.StageView;

public class StageConverter extends AbstractViewConverter<Stage, StageView> {

    public final static String[] IGNORED_PROPS_STAGE_VIEW = new String[] {};

    public final static String[] IGNORED_PROPS_VIEW_STAGE = new String[] {};

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_STAGE_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_STAGE;
    }

    @Override
    public void convertToView(Stage model, StageView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
        view.setProjectId(model.getProject().getId());
        copyModelModification(model.getModelModification(), view);
    }

    @Override
    public void convertToModel(StageView view, Stage model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
        if (view.getProjectId() != null) {
            Project project = new Project();
            project.setId(view.getProjectId());
            model.setProject(project);
        }
    }

    @Override
    public Stage generateModel(Object params) {
        return new Stage();
    }

    @Override
    public StageView generateView(Stage model, Object params) {
        return new StageView(model);
    }

}
