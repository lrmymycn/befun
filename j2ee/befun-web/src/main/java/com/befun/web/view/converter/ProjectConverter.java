package com.befun.web.view.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.estate.Media;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Suburb;
import com.befun.web.view.ProjectView;

public class ProjectConverter extends AbstractEstateViewConverter<Project, ProjectView> {

    public final static String[] IGNORED_PROPS_PROJECT_VIEW = new String[] {};

    public final static String[] IGNORED_PROPS_VIEW_PROJECT = new String[] {};

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_PROJECT_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_PROJECT;
    }

    @Override
    public void convertToView(Project model, ProjectView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
        if (model.getPicture() != null) {
            view.setPictureId(model.getPicture().getId());
        }
        if (model.getLogo() != null) {
            view.setLogoId(model.getLogo().getId());
        }
        view.setAreaId(model.getSuburb().getArea().getId());
        view.setSuburbId(model.getSuburb().getId());
        view.setSuburbName(model.getSuburb().getName());
        view.setAreaName(model.getSuburb().getArea().getName());
        view.setSuburbDescription(model.getSuburb().getDescription());
        copyModelModification(model.getModelModification(), view);
    }

    @Override
    public void convertToModel(ProjectView view, Project model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
        if (view.getPictureId() != null) {
            Media m = new Media();
            m.setId(view.getPictureId());
            model.setPicture(m);
        }
        if (view.getLogoId() != null) {
            Media m = new Media();
            m.setId(view.getLogoId());
            model.setLogo(m);
        }
        if (view.getSuburbId() != null) {
            Suburb s = new Suburb();
            s.setId(view.getSuburbId());
            model.setSuburb(s);
        }
    }

    @Override
    public Project generateModel(Object params) {
        return new Project();
    }

    @Override
    public ProjectView generateView(Project model, Object params) {
        return new ProjectView(model);
    }

}
