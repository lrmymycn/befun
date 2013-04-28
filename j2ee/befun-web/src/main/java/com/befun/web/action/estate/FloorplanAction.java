package com.befun.web.action.estate;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Floorplan;
import com.befun.service.IBaseService;
import com.befun.service.estate.FloorplanService;
import com.befun.service.query.FloorplanQueryCondition;
import com.befun.web.action.CRUDAction;
import com.befun.web.view.FloorplanView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("FloorplanAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FloorplanAction extends CRUDAction<Floorplan, FloorplanView> {

    private static final long serialVersionUID = 1423434908904040130L;

    private FloorplanQueryCondition qc;

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService service;

    public void setQc(FloorplanQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public FloorplanQueryCondition getQc() {
        return qc;
    }

    @Override
    public FloorplanView getView() {
        return this.view;
    }

    @Override
    public void setView(FloorplanView view) {
        this.view = view;
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
