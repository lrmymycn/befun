package com.befun.web.action.estate;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Building;
import com.befun.service.IBaseService;
import com.befun.service.estate.BuildingService;
import com.befun.service.query.estate.BuildingQueryCondition;
import com.befun.web.action.CRUDAction;
import com.befun.web.view.BuildingView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("BuildingAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BuildingAction extends CRUDAction<Building, BuildingView> {

    private static final long serialVersionUID = 7080545951565930680L;

    private BuildingQueryCondition qc = new BuildingQueryCondition();

    @Resource
    @Qualifier("BuildingService")
    private BuildingService service;

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

    @Override
    public ViewConverter<Building, BuildingView> getConverter() {
        return ConverterFactory.getConverter(Building.class);
    }

    @Override
    public IBaseService<Building, Long> getService() {
        return service;
    }

}
