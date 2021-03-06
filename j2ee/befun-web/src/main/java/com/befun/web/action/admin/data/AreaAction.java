package com.befun.web.action.admin.data;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Area;
import com.befun.service.IBaseService;
import com.befun.service.query.estate.AreaQueryCondition;
import com.befun.web.action.admin.AdminAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminAreaAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AreaAction<T extends Area, V extends AreaView> extends AdminAction<Area, AreaView> {

    private static final long serialVersionUID = -6022462134369571083L;

    private AreaQueryCondition qc = new AreaQueryCondition();

    public AreaAction(){
        this.view = new AreaView();
    }
    
    public String demandById() {
        try {
            Area obj = this.areaService.getDetail(this.getId());
            this.view = this.getConverter().convertToView(obj);
        } catch (Exception ex) {
            String errMsg = "Query failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String createOrUpdate() {
        try {
            Area model = this.getConverter().convertToModel(this.view);
            this.areaService.saveOrUpdateWithPolylines(model, this.getUpdateIgnoredProperties());
            this.addActionMessage("Update successfully!");
        } catch (Exception ex) {
            String errMsg = "Update failure! Object:" + this.view;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }
    
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
        return this.areaService;
    }

}
