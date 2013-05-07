package com.befun.web.action.estate;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Area;
import com.befun.service.IBaseService;
import com.befun.service.estate.AreaService;
import com.befun.service.query.estate.AreaQueryCondition;
import com.befun.web.action.CRUDAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AreaAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AreaAction extends CRUDAction<Area, AreaView> {

    private static final long serialVersionUID = -6022462134369571083L;

    private AreaQueryCondition qc = new AreaQueryCondition();

    @Resource
    @Qualifier("AreaService")
    private AreaService service;

    public void setQc(AreaQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public AreaQueryCondition getQc() {
        return qc;
    }

    public AreaView getView() {
        return this.view;
    }

    public void setView(AreaView view) {
        this.view = view;
    }
    
    @Override
    public ViewConverter<Area, AreaView> getConverter() {
        return ConverterFactory.getConverter(Area.class);
    }

    @Override
    public IBaseService<Area, Long> getService() {
        return service;
    }

}
