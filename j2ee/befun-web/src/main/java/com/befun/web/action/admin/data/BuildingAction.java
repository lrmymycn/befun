package com.befun.web.action.admin.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Stage;
import com.befun.domain.estate.Suburb;
import com.befun.service.IBaseService;
import com.befun.service.query.estate.AreaQueryCondition;
import com.befun.service.query.estate.BuildingQueryCondition;
import com.befun.service.query.estate.ProjectQueryCondition;
import com.befun.service.query.estate.StageQueryCondition;
import com.befun.service.query.estate.SuburbQueryCondition;
import com.befun.web.action.admin.AdminAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.BuildingView;
import com.befun.web.view.ProjectView;
import com.befun.web.view.StageView;
import com.befun.web.view.SuburbView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminBuildingAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BuildingAction<T extends Building, V extends BuildingView> extends AdminAction<Building, BuildingView> {

    private static final long serialVersionUID = 7080545951565930680L;

    private Long paramAreaId = null;

    private Long paramSuburbId = null;

    private Long paramProjectId = null;

    private BuildingQueryCondition qc = new BuildingQueryCondition();

    private List<AreaView> qcAreas = new ArrayList<AreaView>();

    private List<SuburbView> qcSuburbs = new ArrayList<SuburbView>();

    private List<ProjectView> qcProjects = new ArrayList<ProjectView>();

    private List<StageView> qcStages = new ArrayList<StageView>();

    public BuildingAction() {
        this.view = new BuildingView();
    }

    public String createPage() {
        this.prepareEditorList();
        return super.createPage();
    }

    public String demand() {
        this.qc.getProQC().setEnabled(null);
        this.qc.getProQC().getSuburbQC().setEnabled(null);
        return super.demand();        
    }
    
    @Override
    public String demandById() {
        String rs = super.demandById();
        this.prepareEditorList();
        return rs;
    }
    
    protected void prepareQueryList() {
        AreaQueryCondition queryCondition = new AreaQueryCondition();
        queryCondition.setEnabled(null);
        List<Area> areas = this.areaService.query(queryCondition);
        AreaView av = null;
        for (Area a : areas) {
            av = areaConverter.convertToView(a);
            qcAreas.add(av);
        }
        if (this.getQc() != null && this.getQc().getProQC() != null && this.getQc().getProQC().getSuburbQC() != null
            && this.getQc().getProQC().getSuburbQC().getAreaId() != null) {
            SuburbQueryCondition sQC = this.getQc().getProQC().getSuburbQC();
            sQC.setEnabled(null);
            List<Suburb> suburbs = this.suburbService.query(sQC);
            SuburbView sv = null;
            for (Suburb s : suburbs) {
                sv = suburbConverter.convertToView(s);
                qcSuburbs.add(sv);
            }
        }

        ProjectQueryCondition pQC = null;
        if (this.getQc() != null && this.getQc().getProQC() != null) {
            pQC = this.qc.getProQC();
        } else {
            pQC = new ProjectQueryCondition();
        }
        pQC.setEnabled(null);
        List<Project> projects = this.projectService.query(pQC);
        ProjectView psv = null;
        for (Project s : projects) {
            psv = projectConverter.convertToView(s);
            qcProjects.add(psv);
        }

        if (this.qc != null && this.qc.getProjectId() != null) {
            StageQueryCondition stQC = new StageQueryCondition();
            stQC.setProjectId(this.qc.getProjectId());
            stQC.setEnabled(null);
            List<Stage> stages = this.stageService.query(stQC);
            StageView sv = null;
            for (Stage s : stages) {
                sv = stageConverter.convertToView(s);
                qcStages.add(sv);
            }
        }
    }

    private void prepareEditorList() {
        AreaQueryCondition queryCondition = new AreaQueryCondition();
        queryCondition.setEnabled(null);
        List<Area> areas = this.areaService.query(queryCondition);
        AreaView av = null;
        for (Area a : areas) {
            av = areaConverter.convertToView(a);
            qcAreas.add(av);
        }
        Long stageId = this.view.getStageId();
        if (stageId != null) {
            Stage stage = this.stageService.get(stageId);
            this.paramProjectId = stage.getProject().getId();
            this.paramSuburbId = stage.getProject().getSuburb().getId();
            this.paramAreaId = stage.getProject().getSuburb().getArea().getId();
        }
        if (this.paramAreaId != null) {
            SuburbQueryCondition sQC = new SuburbQueryCondition();
            sQC.setAreaId(this.paramAreaId);
            sQC.setEnabled(null);
            List<Suburb> suburbs = this.suburbService.query(sQC);
            SuburbView sv = null;
            for (Suburb s : suburbs) {
                sv = suburbConverter.convertToView(s);
                qcSuburbs.add(sv);
            }
        }

        ProjectQueryCondition projectQc = new ProjectQueryCondition();
        projectQc.setSuburbId(this.paramSuburbId);
        projectQc.setEnabled(null);
        List<Project> projects = this.projectService.query(projectQc);
        ProjectView psv = null;
        for (Project s : projects) {
            psv = projectConverter.convertToView(s);
            qcProjects.add(psv);
        }

        if (this.paramProjectId != null) {
            StageQueryCondition stQC = new StageQueryCondition();
            stQC.setProjectId(this.paramProjectId);
            stQC.setEnabled(null);
            List<Stage> stages = this.stageService.query(stQC);
            StageView sv = null;
            for (Stage s : stages) {
                sv = stageConverter.convertToView(s);
                qcStages.add(sv);
            }
        }
    }
    
    public Long getParamAreaId() {
        return paramAreaId;
    }

    public void setParamAreaId(Long paramAreaId) {
        this.paramAreaId = paramAreaId;
    }

    public Long getParamSuburbId() {
        return paramSuburbId;
    }

    public void setParamSuburbId(Long paramSuburbId) {
        this.paramSuburbId = paramSuburbId;
    }

    public Long getParamProjectId() {
        return paramProjectId;
    }

    public void setParamProjectId(Long paramProjectId) {
        this.paramProjectId = paramProjectId;
    }

    public void setQc(BuildingQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public BuildingQueryCondition getQc() {
        return qc;
    }

    public BuildingView getView() {
        return this.view;
    }

    public void setView(BuildingView view) {
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

    @Override
    public ViewConverter<Building, BuildingView> getConverter() {
        return ConverterFactory.getConverter(Building.class);
    }

    @Override
    public IBaseService<Building, Long> getService() {
        return this.buildingService;
    }

}
