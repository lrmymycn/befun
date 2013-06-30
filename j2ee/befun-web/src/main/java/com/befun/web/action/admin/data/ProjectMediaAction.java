package com.befun.web.action.admin.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.ProjectMedia;
import com.befun.domain.estate.Suburb;
import com.befun.service.IBaseService;
import com.befun.service.query.estate.AreaQueryCondition;
import com.befun.service.query.estate.ProjectMediaQueryCondition;
import com.befun.service.query.estate.ProjectQueryCondition;
import com.befun.service.query.estate.SuburbQueryCondition;
import com.befun.web.action.admin.AdminAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.ProjectMediaView;
import com.befun.web.view.ProjectView;
import com.befun.web.view.SuburbView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminProjectMediaAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectMediaAction<T extends ProjectMedia, V extends ProjectMediaView> extends AdminAction<ProjectMedia, ProjectMediaView> {

    private static final long serialVersionUID = -6022462134369571083L;

    private ProjectMediaQueryCondition qc = new ProjectMediaQueryCondition();

    private Long qcAreaId;

    private Long qcSuburbId;

    private List<AreaView> qcAreas = new ArrayList<AreaView>();

    private List<SuburbView> qcSuburbs = new ArrayList<SuburbView>();

    private List<ProjectView> qcProjects = new ArrayList<ProjectView>();
    
    public ProjectMediaAction(){
        this.view = new ProjectMediaView();
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
        ProjectQueryCondition pQC = new ProjectQueryCondition();
        if (this.qcAreaId != null) {
            SuburbQueryCondition sQC = new SuburbQueryCondition();
            sQC.setAreaId(this.qcAreaId);
            pQC.setSuburbQC(sQC);
            sQC.setEnabled(null);
            List<Suburb> suburbs = this.suburbService.query(sQC);
            SuburbView sv = null;
            for (Suburb s : suburbs) {
                sv = suburbConverter.convertToView(s);
                qcSuburbs.add(sv);
            }
        }
        pQC.setSuburbId(this.qcSuburbId);
        pQC.setEnabled(null);
        pQC.getSuburbQC().setEnabled(null);
        List<Project> projects = this.projectService.query(pQC);
        ProjectView psv = null;
        for (Project s : projects) {
            psv = projectConverter.convertToView(s);
            qcProjects.add(psv);
        }
    }

    public void setQc(ProjectMediaQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public ProjectMediaQueryCondition getQc() {
        return qc;
    }

    public ProjectMediaView getView() {
        return this.view;
    }

    public void setView(ProjectMediaView view) {
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

    public void setQcAreas(List<AreaView> qcAreas) {
        this.qcAreas = qcAreas;
    }

    public List<SuburbView> getQcSuburbs() {
        return qcSuburbs;
    }

    public void setQcSuburbs(List<SuburbView> qcSuburbs) {
        this.qcSuburbs = qcSuburbs;
    }

    public List<ProjectView> getQcProjects() {
        return qcProjects;
    }

    public void setQcProjects(List<ProjectView> qcProjects) {
        this.qcProjects = qcProjects;
    }

    @Override
    public ViewConverter<ProjectMedia, ProjectMediaView> getConverter() {
        return ConverterFactory.getConverter(ProjectMedia.class);
    }

    @Override
    public IBaseService<ProjectMedia, Long> getService() {
        return this.projectMediaService;
    }

}
