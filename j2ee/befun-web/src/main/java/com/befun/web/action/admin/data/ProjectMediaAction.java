package com.befun.web.action.admin.data;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.ProjectMedia;
import com.befun.service.IBaseService;
import com.befun.service.estate.ProjectMediaService;
import com.befun.service.query.ProjectMediaQueryCondition;
import com.befun.web.action.JmesaAction;
import com.befun.web.view.ProjectMediaView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminProjectMediaAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectMediaAction<T extends ProjectMedia, V extends ProjectMediaView> extends JmesaAction<ProjectMedia, ProjectMediaView> {

    private static final long serialVersionUID = -6022462134369571083L;

    private ProjectMediaQueryCondition qc = new ProjectMediaQueryCondition();

    @Resource
    @Qualifier("ProjectMediaService")
    private ProjectMediaService service;

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

    @Override
    public ViewConverter<ProjectMedia, ProjectMediaView> getConverter() {
        return ConverterFactory.getConverter(ProjectMedia.class);
    }

    @Override
    public IBaseService<ProjectMedia, Long> getService() {
        return service;
    }

}
