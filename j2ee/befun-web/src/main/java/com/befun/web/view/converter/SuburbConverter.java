package com.befun.web.view.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.Suburb;
import com.befun.web.view.SuburbView;

public class SuburbConverter extends AbstractViewConverter<Suburb, SuburbView> {

    public final static String[] IGNORED_PROPS_SUBURB_VIEW = new String[] {};

    public final static String[] IGNORED_PROPS_VIEW_SUBURB = new String[] {};

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_SUBURB_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_SUBURB;
    }

    @Override
    public void convertToView(Suburb model, SuburbView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
        if (model.getArea() != null) {
            view.setAreaId(model.getArea().getId());
        }
        copyModelModification(model.getModelModification(), view);

    }

    @Override
    public void convertToModel(SuburbView view, Suburb model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
        if (view.getAreaId() != null) {
            Area a = new Area();
            a.setId(view.getAreaId());
            model.setArea(a);
        }
    }

    @Override
    public Suburb generateModel(Object params) {
        return new Suburb();
    }

    @Override
    public SuburbView generateView(Suburb model, Object params) {
        return new SuburbView(model);
    }

}
