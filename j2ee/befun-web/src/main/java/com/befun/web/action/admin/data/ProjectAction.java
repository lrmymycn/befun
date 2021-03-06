package com.befun.web.action.admin.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Suburb;
import com.befun.service.IBaseService;
import com.befun.service.query.estate.AreaQueryCondition;
import com.befun.service.query.estate.ProjectQueryCondition;
import com.befun.service.query.estate.SuburbQueryCondition;
import com.befun.web.action.admin.AdminAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.ProjectView;
import com.befun.web.view.SuburbView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminProjectAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectAction<T extends Project, V extends ProjectView> extends AdminAction<Project, ProjectView> {

    private static final long serialVersionUID = 7103590937940363546L;

    private ProjectQueryCondition qc = new ProjectQueryCondition();

    private List<AreaView> qcAreas = new ArrayList<AreaView>();

    private List<SuburbView> qcSuburbs = new ArrayList<SuburbView>();

    public ProjectAction() {
        this.view = new ProjectView();
    }

    @Override
    public String removeDependency() {
        try {
            this.projectService.deleteDependency(this.id);
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

    public String demand() {
        this.qc.getSuburbQC().setEnabled(null);
        return super.demand();        
    }
    
    @Override
    public String demandById() {
        String rs = super.demandById();
        this.prepareEditorList();
        return rs;
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
        SuburbQueryCondition suburbQc = new SuburbQueryCondition();
        suburbQc.setEnabled(null);
        if (this.view != null && this.view.getAreaId() != null) {
            suburbQc.setAreaId(this.view.getAreaId());
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
        if (this.qc != null && this.qc.getSuburbQC() != null) {
            SuburbQueryCondition suburbQc = this.qc.getSuburbQC();
            suburbQc.setEnabled(null);
            List<Suburb> suburbs = this.suburbService.query(suburbQc);
            SuburbView sv = null;
            for (Suburb s : suburbs) {
                sv = suburbConverter.convertToView(s);
                qcSuburbs.add(sv);
            }
        }
    }

    public void setQc(ProjectQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public ProjectQueryCondition getQc() {
        return qc;
    }

    public ProjectView getView() {
        return this.view;
    }

    public void setView(ProjectView view) {
        this.view = view;
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

    @Override
    public ViewConverter<Project, ProjectView> getConverter() {
        return ConverterFactory.getConverter(Project.class);
    }

    @Override
    public IBaseService<Project, Long> getService() {
        return projectService;
    }

}
