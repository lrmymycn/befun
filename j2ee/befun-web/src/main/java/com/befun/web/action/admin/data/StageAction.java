package com.befun.web.action.admin.data;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Stage;
import com.befun.service.IBaseService;
import com.befun.service.estate.StageService;
import com.befun.service.query.StageQueryCondition;
import com.befun.web.action.JmesaAction;
import com.befun.web.view.StageView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminStageAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StageAction extends JmesaAction<Stage, StageView> {

    private static final long serialVersionUID = -5402712598405256802L;

    private StageQueryCondition qc;

    @Resource
    @Qualifier("StageService")
    private StageService service;

    public void setQc(StageQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public StageQueryCondition getQc() {
        return qc;
    }

    @Override
    public StageView getView() {
        return this.view;
    }

    @Override
    public void setView(StageView view) {
        this.view = view;
    }
    
    @Override
    public ViewConverter<Stage, StageView> getConverter() {
        return ConverterFactory.getConverter(Stage.class);
    }

    @Override
    public IBaseService<Stage, Long> getService() {
        return service;
    }
}
