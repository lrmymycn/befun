package com.befun.web.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.ModelModification;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Stage;
import com.befun.domain.estate.Suburb;

public class ViewCopier {

    public final static String[] IGNORE_PROPS_AREA_VIEW = new String[] { "suburbs" };

    public final static String[] IGNORE_PROPS_VIEW_AREA = new String[] { "suburbs" };

    public final static String[] IGNORE_PROPS_SUBURB_VIEW = new String[] {};

    public final static String[] IGNORE_PROPS_VIEW_SUBURB = new String[] {};

    public final static String[] IGNORE_PROPS_PRO_VIEW = new String[] {};

    public final static String[] IGNORE_PROPS_VIEW_PRO = new String[] {};

    public final static String[] IGNORE_PROPS_STAGE_VIEW = new String[] {};

    public final static String[] IGNORE_PROPS_VIEW_STAGE = new String[] {};

    public final static String[] IGNORE_PROPS_BUILDING_VIEW = new String[] {};

    public final static String[] IGNORE_PROPS_VIEW_BUILDING = new String[] {};

    public final static String[] IGNORE_PROPS_FLOORPLAN_VIEW = new String[] { "apartments" };

    public final static String[] IGNORE_PROPS_VIEW_FLOORPLAN = new String[] { "apartments" };

    public final static String[] IGNORE_PROPS_APARTMENT_VIEW = new String[] {};

    public final static String[] IGNORE_PROPS_VIEW_APARTMENT = new String[] {};

    public static void copyModelModification(ModelModification source, BaseView<?> target) {
        target.setCreationDate(source.getCreationDate());
        target.setEnabled(source.isEnabled());
        target.setLastModifiedDate(source.getLastModifiedDate());
        target.setRemoved(source.isRemoved());
    }

    public static String[] generateIgnoredProps(String[] ignoredProperties, List<String> externalIgnoredProperties) {
        List<String> ignoredProps = new ArrayList<String>();
        for (String p : ignoredProperties) {
            ignoredProps.add(p);
        }
        if (externalIgnoredProperties != null) {
            ignoredProps.addAll(externalIgnoredProperties);
        }
        return ignoredProps.toArray(new String[] {});
    }

    public static void copyAreaToView(Area source, AreaView target) {
        copyAreaToView(source, target, IGNORE_PROPS_AREA_VIEW);
    }

    public static void copyViewToArea(AreaView source, Area target) {
        copyViewToArea(source, target, IGNORE_PROPS_VIEW_AREA);
    }

    public static void copyAreaToView(Area source, AreaView target, List<String> externalIgnoredProperties) {
        String[] ignoreProps = generateIgnoredProps(IGNORE_PROPS_AREA_VIEW, externalIgnoredProperties);
        copyAreaToView(source, target, ignoreProps);
    }

    private static void copyAreaToView(Area source, AreaView target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        copyModelModification(source.getModelModification(), target);
    }

    private static void copyViewToArea(AreaView source, Area target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
    }

    public static void copySuburbToView(Suburb source, SuburbView target) {
        copySuburbToView(source, target, IGNORE_PROPS_SUBURB_VIEW);
    }

    public static void copyViewToSuburb(SuburbView source, Suburb target) {
        copyViewToSuburb(source, target, IGNORE_PROPS_VIEW_SUBURB);
    }

    public static void copySuburbToView(Suburb source, SuburbView target, List<String> externalIgnoredProperties) {
        String[] ignoreProps = generateIgnoredProps(IGNORE_PROPS_SUBURB_VIEW, externalIgnoredProperties);
        copySuburbToView(source, target, ignoreProps);
    }

    private static void copySuburbToView(Suburb source, SuburbView target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        if (source.getArea() != null) {
            target.setAreaId(source.getArea().getId());
        }
        copyModelModification(source.getModelModification(), target);
    }

    private static void copyViewToSuburb(SuburbView source, Suburb target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        if (source.getAreaId() != null) {
            Area a = new Area();
            a.setId(source.getAreaId());
            target.setArea(a);
        }
    }

    public static void copyProjectToView(Project source, ProjectView target) {
        copyProjectToView(source, target, IGNORE_PROPS_PRO_VIEW);
    }

    public static void copyViewToProject(ProjectView source, Project target) {
        copyViewToProject(source, target, IGNORE_PROPS_VIEW_PRO);
    }

    public static void copyProjectToView(Project source, ProjectView target, List<String> externalIgnoredProperties) {
        String[] ignoreProps = generateIgnoredProps(IGNORE_PROPS_PRO_VIEW, externalIgnoredProperties);
        copyProjectToView(source, target, ignoreProps);
    }

    private static void copyProjectToView(Project source, ProjectView target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        if (source.getPicture() != null) {
            target.setPictureId(source.getPicture().getId());
        }
        if (source.getLogo() != null) {
            target.setLogoId(source.getLogo().getId());
        }
        target.setAreaId(source.getSuburb().getArea().getId());
        target.setSuburbId(source.getSuburb().getId());
        copyModelModification(source.getModelModification(), target);
    }

    private static void copyViewToProject(ProjectView source, Project target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        if (source.getPictureId() != null) {
            Media m = new Media();
            m.setId(source.getPictureId());
            target.setPicture(m);
        }
        if (source.getLogoId() != null) {
            Media m = new Media();
            m.setId(source.getLogoId());
            target.setLogo(m);
        }
    }

    public static void copyStageToView(Stage source, StageView target) {
        copyStageToView(source, target, IGNORE_PROPS_STAGE_VIEW);
    }

    public static void copyViewToStage(StageView source, Stage target) {
        copyViewToStage(source, target, IGNORE_PROPS_VIEW_STAGE);
    }

    public static void copyStageToView(Stage source, StageView target, List<String> externalIgnoredProperties) {
        String[] ignoreProps = generateIgnoredProps(IGNORE_PROPS_STAGE_VIEW, externalIgnoredProperties);
        copyStageToView(source, target, ignoreProps);
    }

    private static void copyStageToView(Stage source, StageView target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        target.setProjectId(source.getProject().getId());
        copyModelModification(source.getModelModification(), target);
    }

    private static void copyViewToStage(StageView source, Stage target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        if (source.getProjectId() != null) {
            Project project = new Project();
            project.setId(source.getProjectId());
            target.setProject(project);
        }
    }

    public static void copyBuildingToView(Building source, BuildingView target) {
        copyBuildingToView(source, target, IGNORE_PROPS_BUILDING_VIEW);
    }

    public static void copyViewToBuilding(BuildingView source, Building target) {
        copyViewToBuilding(source, target, IGNORE_PROPS_VIEW_BUILDING);
    }

    public static void copyBuildingToView(Building source, BuildingView target, List<String> externalIgnoredProperties) {
        String[] ignoreProps = generateIgnoredProps(IGNORE_PROPS_BUILDING_VIEW, externalIgnoredProperties);
        copyBuildingToView(source, target, ignoreProps);
    }

    public static void copyBuildingToView(Building source, BuildingView target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        target.setStageId(source.getStage().getId());
        copyModelModification(source.getModelModification(), target);
    }

    public static void copyViewToBuilding(BuildingView source, Building target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        if (source.getStageId() != null) {
            Stage stage = new Stage();
            stage.setId(source.getStageId());
            target.setStage(stage);
        }
    }

    public static void copyFloorplanToView(Floorplan source, FloorplanView target) {
        copyFloorplanToView(source, target, IGNORE_PROPS_FLOORPLAN_VIEW);
    }

    public static void copyViewToFloorplan(FloorplanView source, Floorplan target) {
        copyViewToFloorplan(source, target, IGNORE_PROPS_VIEW_FLOORPLAN);
    }

    public static void copyFloorplanToView(Floorplan source, FloorplanView target, List<String> externalIgnoredProperties) {
        String[] ignoreProps = generateIgnoredProps(IGNORE_PROPS_FLOORPLAN_VIEW, externalIgnoredProperties);
        copyFloorplanToView(source, target, ignoreProps);
    }

    public static void copyFloorplanToView(Floorplan source, FloorplanView target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        target.setBuildingId(source.getBuilding().getId());
        if (source.getPublicPicture() != null) {
            target.setPublicPictureId(source.getPublicPicture().getId());
        }
        if (source.getSalePicture() != null) {
            target.setSalePictureId(source.getSalePicture().getId());
        }
        copyModelModification(source.getModelModification(), target);
    }

    public static void copyViewToFloorplan(FloorplanView source, Floorplan target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        if (source.getBuildingId() != null) {
            Building building = new Building();
            building.setId(source.getBuildingId());
            target.setBuilding(building);
        }
        if (source.getPublicPictureId() != null) {
            Media m = new Media();
            m.setId(source.getPublicPictureId());
            target.setPublicPicture(m);
        }
        if (source.getSalePictureId() != null) {
            Media m = new Media();
            m.setId(source.getSalePictureId());
            target.setSalePicture(m);
        }
    }

    public static void copyApartmentToView(Apartment source, ApartmentView target) {
        copyApartmentToView(source, target, IGNORE_PROPS_APARTMENT_VIEW);
    }

    public static void copyViewToApartment(ApartmentView source, Apartment target) {
        copyViewToApartment(source, target, IGNORE_PROPS_VIEW_APARTMENT);
    }

    public static void copyApartmentToView(Apartment source, ApartmentView target, List<String> externalIgnoredProperties) {
        String[] ignoreProps = generateIgnoredProps(IGNORE_PROPS_APARTMENT_VIEW, externalIgnoredProperties);
        copyApartmentToView(source, target, ignoreProps);
    }

    private static void copyApartmentToView(Apartment source, ApartmentView target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        target.setFloorplanId(source.getFloorplan().getId());
        copyModelModification(source.getModelModification(), target);
    }

    private static void copyViewToApartment(ApartmentView source, Apartment target, String[] ignoredProperties) {
        BeanUtils.copyProperties(source, target, ignoredProperties);
        if (source.getFloorplanId() != null) {
            Floorplan floorplan = new Floorplan();
            floorplan.setId(source.getFloorplanId());
            target.setFloorplan(floorplan);
        }
    }
}
