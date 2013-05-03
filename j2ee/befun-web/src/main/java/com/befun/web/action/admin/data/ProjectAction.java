package com.befun.web.action.admin.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Suburb;
import com.befun.service.IBaseService;
import com.befun.service.estate.AreaService;
import com.befun.service.estate.ProjectService;
import com.befun.service.estate.SuburbService;
import com.befun.service.query.AreaQueryCondition;
import com.befun.service.query.ProjectQueryCondition;
import com.befun.service.query.SuburbQueryCondition;
import com.befun.web.action.JmesaAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.ProjectView;
import com.befun.web.view.SuburbView;
import com.befun.web.view.converter.AreaConverter;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.SuburbConverter;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminProjectAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectAction<T extends Project, V extends ProjectView> extends JmesaAction<Project, ProjectView> {

    private static final long serialVersionUID = 7103590937940363546L;

    private ProjectQueryCondition qc = new ProjectQueryCondition();

    private List<AreaView> qcAreas = new ArrayList<AreaView>();

    private List<SuburbView> qcSuburbs = new ArrayList<SuburbView>();

    private AreaConverter areaConverter = ConverterFactory.getConverter(Area.class);

    private SuburbConverter suburbConverter = ConverterFactory.getConverter(Suburb.class);

    @Resource
    @Qualifier("ProjectService")
    private ProjectService service;

    @Resource
    @Qualifier("SuburbService")
    private SuburbService suburbService;

    @Resource
    @Qualifier("AreaService")
    private AreaService areaService;
    
    protected void prepareQueryList() {
        AreaQueryCondition queryCondition = new AreaQueryCondition();
        queryCondition.setEnabled(null);
        List<Area> areas = this.areaService.query(queryCondition);
        AreaView av = null;
        for (Area a : areas) {
            av = areaConverter.convertToView(a);
            qcAreas.add(av);
        }
        if (this.qc != null && this.qc.getSuburbQC() != null) {
            SuburbQueryCondition sQC = this.qc.getSuburbQC();
            sQC.setEnabled(null);
            List<Suburb> suburbs = this.suburbService.query(sQC);
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
        return service;
    }

}
