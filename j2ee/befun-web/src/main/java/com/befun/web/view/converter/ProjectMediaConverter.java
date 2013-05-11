package com.befun.web.view.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.estate.Project;
import com.befun.domain.estate.ProjectMedia;
import com.befun.web.view.ProjectMediaView;

public class ProjectMediaConverter extends AbstractEstateViewConverter<ProjectMedia, ProjectMediaView> {

    public final static String[] IGNORED_PROPS_PM_VIEW = new String[] {};

    public final static String[] IGNORED_PROPS_VIEW_PM = new String[] {};

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_PM_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_PM;
    }

    @Override
    public void convertToView(ProjectMedia model, ProjectMediaView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
        view.setProjectId(model.getProject().getId());
        view.setProjectName(model.getProject().getName());
    }

    @Override
    public void convertToModel(ProjectMediaView view, ProjectMedia model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
        if (view.getProjectId() != null) {
            Project project = new Project();
            project.setId(view.getProjectId());
            model.setProject(project);
        }
    }

    @Override
    public ProjectMedia generateModel(Object params) {
        return new ProjectMedia();
    }

    @Override
    public ProjectMediaView generateView(ProjectMedia model, Object params) {
        return new ProjectMediaView(model);
    }

}
