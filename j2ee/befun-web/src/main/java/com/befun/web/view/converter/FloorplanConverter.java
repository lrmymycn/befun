package com.befun.web.view.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Media;
import com.befun.web.view.FloorplanView;

public class FloorplanConverter extends AbstractEstateViewConverter<Floorplan, FloorplanView> {

    public final static String[] IGNORED_PROPS_FLOORPLAN_VIEW = new String[] { "apartments" };

    public final static String[] IGNORED_PROPS_VIEW_FLOORPLAN = new String[] { "apartments" };

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_FLOORPLAN_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_FLOORPLAN;
    }

    @Override
    public void convertToView(Floorplan model, FloorplanView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
        view.setBuildingId(model.getBuilding().getId());
        view.setBuildingNum(model.getBuilding().getBuildingNumber());
        view.setStageName(model.getBuilding().getStage().getName());
        view.setProjectName(model.getBuilding().getStage().getProject().getName());
        view.setProjectId(model.getBuilding().getStage().getProject().getId());
        view.setSuburbName(model.getBuilding().getStage().getProject().getSuburb().getName());
        view.setSuburbId(model.getBuilding().getStage().getProject().getSuburb().getId());
        view.setSuburbDescription(model.getBuilding().getStage().getProject().getSuburb().getDescription());
        view.setAreaName(model.getBuilding().getStage().getProject().getSuburb().getArea().getName());
        view.setAreaId(model.getBuilding().getStage().getProject().getSuburb().getArea().getId());
        if (model.getAvgPricePerSQM() == null && model.getMinPrice() != null && model.getTotalSize().compareTo(0.0) > 0) {
            Double t = model.getMinPrice() / model.getTotalSize();
            view.setAvgPricePerSQM(t.intValue());
        }
        if (model.getPublicPicture() != null) {
            view.setPublicPictureId(model.getPublicPicture().getId());
        }
        if (model.getSalePicture() != null) {
            view.setSalePictureId(model.getSalePicture().getId());
        }
        copyModelModification(model.getModelModification(), view);
    }

    @Override
    public void convertToModel(FloorplanView view, Floorplan model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
        if (view.getBuildingId() != null) {
            Building building = new Building();
            building.setId(view.getBuildingId());
            model.setBuilding(building);
        }
        if (view.getPublicPictureId() != null) {
            Media m = new Media();
            m.setId(view.getPublicPictureId());
            model.setPublicPicture(m);
        }
        if (view.getSalePictureId() != null) {
            Media m = new Media();
            m.setId(view.getSalePictureId());
            model.setSalePicture(m);
        }
    }

    @Override
    public Floorplan generateModel(Object params) {
        return new Floorplan();
    }

    @Override
    public FloorplanView generateView(Floorplan model, Object params) {
        return new FloorplanView(model);
    }

}
