package com.befun.web.view.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.estate.Area;
import com.befun.web.view.AreaView;

public class AreaConverter extends AbstractViewConverter<Area, AreaView> {

    public final static String[] IGNORED_PROPS_AREA_VIEW = new String[] { "suburbs" };

    public final static String[] IGNORED_PROPS_VIEW_AREA = new String[] { "suburbs" };

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_AREA_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_AREA;
    }

    @Override
    public void convertToView(Area model, AreaView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
        copyModelModification(model.getModelModification(), view);

    }

    @Override
    public void convertToModel(AreaView view, Area model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
    }

    @Override
    public Area generateModel(Object params) {
        return new Area();
    }

    @Override
    public AreaView generateView(Area model, Object params) {
        return new AreaView(model);
    }

}
