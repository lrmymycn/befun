package com.befun.web.view.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Floorplan;
import com.befun.web.view.ApartmentView;

public class ApartmentConverter extends AbstractViewConverter<Apartment, ApartmentView> {

    public final static String[] IGNORED_PROPS_APARTMENT_VIEW = new String[] {};

    public final static String[] IGNORED_PROPS_VIEW_APARTMENT = new String[] {};

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_APARTMENT_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_APARTMENT;
    }

    @Override
    public void convertToView(Apartment model, ApartmentView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
        view.setFloorplanId(model.getFloorplan().getId());
        view.setFloorplanName(model.getFloorplan().getDescription());
        view.setBuildingNum(model.getFloorplan().getBuilding().getBuildingNumber());
        view.setStageName(model.getFloorplan().getBuilding().getStage().getName());
        view.setProjectName(model.getFloorplan().getBuilding().getStage().getProject().getName());
        copyModelModification(model.getModelModification(), view);
    }

    @Override
    public void convertToModel(ApartmentView view, Apartment model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
        if (view.getFloorplanId() != null) {
            Floorplan floorplan = new Floorplan();
            floorplan.setId(view.getFloorplanId());
            model.setFloorplan(floorplan);
        }
    }

    @Override
    public Apartment generateModel(Object params) {
        return new Apartment();
    }

    @Override
    public ApartmentView generateView(Apartment model, Object params) {
        return new ApartmentView(model);
    }

}
