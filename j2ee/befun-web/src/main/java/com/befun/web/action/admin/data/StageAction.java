package com.befun.web.action.admin.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Stage;
import com.befun.domain.estate.Suburb;
import com.befun.service.IBaseService;
import com.befun.service.query.estate.AreaQueryCondition;
import com.befun.service.query.estate.ProjectQueryCondition;
import com.befun.service.query.estate.StageQueryCondition;
import com.befun.service.query.estate.SuburbQueryCondition;
import com.befun.web.action.admin.AdminAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.ProjectView;
import com.befun.web.view.StageView;
import com.befun.web.view.SuburbView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminStageAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StageAction<T extends Stage, V extends StageView> extends AdminAction<Stage, StageView> {

    private static final long serialVersionUID = -5402712598405256802L;

    private Long paramAreaId = null;

    private Long paramSuburbId = null;

    private StageQueryCondition qc = new StageQueryCondition();

    private Long qcAreaId;

    private Long qcSuburbId;

    private List<AreaView> qcAreas = new ArrayList<AreaView>();

    private List<SuburbView> qcSuburbs = new ArrayList<SuburbView>();

    private List<ProjectView> qcProjects = new ArrayList<ProjectView>();

    public StageAction() {
        this.view = new StageView();
    }

    @Override
    public String removeDependency() {
        try {
            this.stageService.deleteDependency(this.id);
            this.addActionMessage("Remove successfully! ID:" + this.id);
        } catch (Exception ex) {
            String errMsg = "Remove failure! Id:" + id;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String createPage() {
        this.prepareEditorList();
        return super.createPage();
    }

    @Override
    public String demandById() {
        String rs = super.demandById();
        this.prepareEditorList();
        return rs;
    }

    protected void prepareQueryList() {
        AreaQueryCondition areaQc = new AreaQueryCondition();
        areaQc.setEnabled(null);
        List<Area> areas = this.areaService.query(areaQc);
        AreaView av = null;
        for (Area a : areas) {
            av = areaConverter.convertToView(a);
            qcAreas.add(av);
        }
        ProjectQueryCondition projectQc = new ProjectQueryCondition();
        if (this.qcAreaId != null) {
            SuburbQueryCondition suburbQc = new SuburbQueryCondition();
            suburbQc.setAreaId(this.qcAreaId);
            projectQc.setSuburbQC(suburbQc);
            suburbQc.setEnabled(null);
            List<Suburb> suburbs = this.suburbService.query(suburbQc);
            SuburbView sv = null;
            for (Suburb s : suburbs) {
                sv = suburbConverter.convertToView(s);
                qcSuburbs.add(sv);
            }
        }
        projectQc.setSuburbId(this.qcSuburbId);
        projectQc.setEnabled(null);
        projectQc.getSuburbQC().setEnabled(null);
        List<Project> projects = this.projectService.query(projectQc);
        ProjectView psv = null;
        for (Project s : projects) {
            psv = projectConverter.convertToView(s);
            qcProjects.add(psv);
        }
    }

    private void prepareEditorList() {
        AreaQueryCondition areaQc = new AreaQueryCondition();
        areaQc.setEnabled(null);
        List<Area> areas = this.areaService.query(areaQc);
        AreaView av = null;
        for (Area a : areas) {
            av = areaConverter.convertToView(a);
            qcAreas.add(av);
        }
        Long projectId = this.view.getProjectId();
        if (projectId != null) {
            Project pro = this.projectService.get(projectId);
            this.paramSuburbId = pro.getSuburb().getId();
            this.paramAreaId = pro.getSuburb().getArea().getId();
        }
        SuburbQueryCondition suburbQc = new SuburbQueryCondition();
        suburbQc.setEnabled(null);
        if (this.paramAreaId != null) {
            suburbQc.setAreaId(this.paramAreaId);
        } else if (qcAreas.size() > 0) {
            av = qcAreas.get(0);
            suburbQc.setAreaId(av.getId());
        }
        List<Suburb> suburbs = this.suburbService.query(suburbQc);
        SuburbView sv = null;
        for (Suburb s : suburbs) {
            sv = suburbConverter.convertToView(s);
            qcSuburbs.add(sv);
        }

        ProjectQueryCondition projectQc = new ProjectQueryCondition();
        projectQc.setSuburbId(this.paramSuburbId);
        projectQc.setEnabled(null);
        projectQc.getSuburbQC().setEnabled(null);
        List<Project> projects = this.projectService.query(projectQc);
        ProjectView psv = null;
        for (Project s : projects) {
            psv = projectConverter.convertToView(s);
            qcProjects.add(psv);
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

    public void setQc(StageQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public StageQueryCondition getQc() {
        return qc;
    }

    public StageView getView() {
        return this.view;
    }

    public void setView(StageView view) {
        this.view = view;
    }

    public Long getQcAreaId() {
        return qcAreaId;
    }

    public void setQcAreaId(Long qcAreaId) {
        this.qcAreaId = qcAreaId;
    }

    public Long getQcSuburbId() {
        return qcSuburbId;
    }

    public void setQcSuburbId(Long qcSuburbId) {
        this.qcSuburbId = qcSuburbId;
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

    @Override
    public ViewConverter<Stage, StageView> getConverter() {
        return ConverterFactory.getConverter(Stage.class);
    }

    @Override
    public IBaseService<Stage, Long> getService() {
        return this.stageService;
    }
}
