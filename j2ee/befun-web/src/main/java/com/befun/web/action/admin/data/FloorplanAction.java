package com.befun.web.action.admin.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.FloorplanType;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Stage;
import com.befun.domain.estate.Suburb;
import com.befun.service.IBaseService;
import com.befun.service.estate.FloorplanService;
import com.befun.service.query.estate.AreaQueryCondition;
import com.befun.service.query.estate.BuildingQueryCondition;
import com.befun.service.query.estate.FloorplanQueryCondition;
import com.befun.service.query.estate.ProjectQueryCondition;
import com.befun.service.query.estate.StageQueryCondition;
import com.befun.service.query.estate.SuburbQueryCondition;
import com.befun.web.action.admin.AdminAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.BuildingView;
import com.befun.web.view.FloorplanView;
import com.befun.web.view.ProjectView;
import com.befun.web.view.StageView;
import com.befun.web.view.SuburbView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminFloorplanAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FloorplanAction<T extends Floorplan, V extends FloorplanView> extends AdminAction<Floorplan, FloorplanView> {

    private static final long serialVersionUID = 1423434908904040130L;

    private static final String[] UPDATE_IGNORED_PROPS = new String[] { "modelModification" };

    private FloorplanQueryCondition qc = new FloorplanQueryCondition();

    private List<AreaView> qcAreas = new ArrayList<AreaView>();

    private List<SuburbView> qcSuburbs = new ArrayList<SuburbView>();

    private List<ProjectView> qcProjects = new ArrayList<ProjectView>();

    private List<StageView> qcStages = new ArrayList<StageView>();

    private List<BuildingView> qcBuildings = new ArrayList<BuildingView>();

    private static List<FloorplanType> floorplanTypes = new ArrayList<FloorplanType>();

    static {
        if (floorplanTypes.size() < 1) {
            floorplanTypes.add(FloorplanType.APARTMENT);
            floorplanTypes.add(FloorplanType.HOUSE);
            floorplanTypes.add(FloorplanType.TOWN_HOUSE);
        }
    }

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService service;
    
    public FloorplanAction(){
        this.view = new FloorplanView();
    }

    protected void prepareQueryList() {
        AreaQueryCondition queryCondition = new AreaQueryCondition();
        // queryCondition.setEnabled(null);
        List<Area> areas = this.areaService.query(queryCondition);
        AreaView av = null;
        for (Area a : areas) {
            av = areaConverter.convertToView(a);
            qcAreas.add(av);
        }
        if (this.qc != null && this.qc.getBdQC() != null && this.qc.getBdQC().getProQC() != null && this.qc.getBdQC().getProQC().getSuburbQC() != null
            && this.qc.getBdQC().getProQC().getSuburbQC().getAreaId() != null) {
            SuburbQueryCondition sQC = this.qc.getBdQC().getProQC().getSuburbQC();
            // sQC.setEnabled(null);
            List<Suburb> suburbs = this.suburbService.query(sQC);
            SuburbView sv = null;
            for (Suburb s : suburbs) {
                sv = suburbConverter.convertToView(s);
                qcSuburbs.add(sv);
            }
        }
        if (this.qc != null && this.qc.getBdQC() != null && this.qc.getBdQC().getProQC() != null && this.qc.getBdQC().getProQC().getSuburbId() != null) {
            ProjectQueryCondition pQC = this.qc.getBdQC().getProQC();
            // sQC.setEnabled(null);
            List<Project> projects = this.projectService.query(pQC);
            ProjectView sv = null;
            for (Project s : projects) {
                sv = projectConverter.convertToView(s);
                qcProjects.add(sv);
            }
        }

        if (this.qc != null && this.qc.getBdQC() != null && this.qc.getBdQC().getProjectId() != null) {
            StageQueryCondition stQC = new StageQueryCondition();
            stQC.setProjectId(this.qc.getBdQC().getProjectId());
            // sQC.setEnabled(null);
            List<Stage> stages = this.stageService.query(stQC);
            StageView sv = null;
            for (Stage s : stages) {
                sv = stageConverter.convertToView(s);
                qcStages.add(sv);
            }
        }
        if (this.qc != null && this.qc.getBdQC() != null && this.qc.getBdQC().getStageId() != null) {
            BuildingQueryCondition bQC = this.qc.getBdQC();
            // sQC.setEnabled(null);
            List<Building> buildings = this.buildingService.query(bQC);
            BuildingView sv = null;
            for (Building s : buildings) {
                sv = buildingConverter.convertToView(s);
                qcBuildings.add(sv);
            }
        }
    }

    public void setQc(FloorplanQueryCondition qc) {
        this.qc = qc;
    }

    public List<FloorplanType> getFloorplanTypes() {
        return floorplanTypes;
    }

    @Override
    public String[] getUpdateIgnoredProperties() {
        return UPDATE_IGNORED_PROPS;
    }

    @Override
    public FloorplanQueryCondition getQc() {
        return qc;
    }

    public FloorplanView getView() {
        return this.view;
    }

    public void setView(FloorplanView view) {
        this.view = view;
    }

    public List<AreaView> getQcAreas() {
        return qcAreas;
    }

    public List<SuburbView> getQcSuburbs() {
        return qcSuburbs;
    }

    public List<ProjectView> getQcProjects() {
        return qcProjects;
    }

    public List<StageView> getQcStages() {
        return qcStages;
    }

    public List<BuildingView> getQcBuildings() {
        return qcBuildings;
    }

    @Override
    public ViewConverter<Floorplan, FloorplanView> getConverter() {
        return ConverterFactory.getConverter(Floorplan.class);
    }

    @Override
    public IBaseService<Floorplan, Long> getService() {
        return service;
    }

}
