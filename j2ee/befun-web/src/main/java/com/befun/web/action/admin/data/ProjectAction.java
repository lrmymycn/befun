package com.befun.web.action.admin.data;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Project;
import com.befun.service.IBaseService;
import com.befun.service.estate.ProjectService;
import com.befun.service.query.ProjectQueryCondition;
import com.befun.web.action.JmesaAction;
import com.befun.web.view.ProjectView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminProjectAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectAction<T extends Project, V extends ProjectView> extends JmesaAction<Project, ProjectView> {

    private static final long serialVersionUID = 7103590937940363546L;

    private ProjectQueryCondition qc = new ProjectQueryCondition();

    @Resource
    @Qualifier("ProjectService")
    private ProjectService service;

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

    @Override
    public ViewConverter<Project, ProjectView> getConverter() {
        return ConverterFactory.getConverter(Project.class);
    }

    @Override
    public IBaseService<Project, Long> getService() {
        return service;
    }

}
