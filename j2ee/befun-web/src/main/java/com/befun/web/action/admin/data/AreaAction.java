package com.befun.web.action.admin.data;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Area;
import com.befun.service.IBaseService;
import com.befun.service.estate.AreaService;
import com.befun.service.query.AreaQueryCondition;
import com.befun.web.action.JmesaAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminAreaAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AreaAction extends JmesaAction<Area, AreaView> {

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

    @Override
    public AreaView getView() {
        return this.view;
    }

    @Override
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
