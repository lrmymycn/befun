package com.befun.web.action.admin.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.Suburb;
import com.befun.service.IBaseService;
import com.befun.service.query.AreaQueryCondition;
import com.befun.service.query.SuburbQueryCondition;
import com.befun.web.action.admin.AdminAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.SuburbView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminSuburbAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SuburbAction<T extends Suburb, V extends SuburbView> extends AdminAction<Suburb, SuburbView> {

    private static final long serialVersionUID = -6022462134369571083L;

    private SuburbQueryCondition qc = new SuburbQueryCondition();

    private List<SuburbView> keyRs = new ArrayList<SuburbView>();

    private List<AreaView> qcAreas = new ArrayList<AreaView>();
    
    public String demandByKey() {
        List<Suburb> queryRs = this.suburbService.queryByInputKey(this.qc.getKey());
        SuburbView tmpV = null;
        for (Suburb s : queryRs) {
            tmpV = this.getConverter().convertToView(s);
            keyRs.add(tmpV);
        }
        return SUCCESS;
    }

    public String demandById() {
        try {
            Suburb obj = this.suburbService.getDetail(this.getId());
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
            Suburb model = this.getConverter().convertToModel(this.view);
            this.suburbService.saveOrUpdateWithPolylines(model, this.getUpdateIgnoredProperties());
            this.addActionMessage("Update successfully!");
        } catch (Exception ex) {
            String errMsg = "Update failure! Object:" + this.view;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    protected void prepareQueryList() {
        AreaQueryCondition queryCondition = new AreaQueryCondition();
//        queryCondition.setEnabled(null);
        List<Area> areas = this.areaService.query(queryCondition);
        AreaView av = null;
        for (Area a : areas) {
            av = areaConverter.convertToView(a);
            qcAreas.add(av);
        }
    }

    public SuburbQueryCondition getQc() {
        return qc;
    }

    public void setQc(SuburbQueryCondition qc) {
        this.qc = qc;
    }

    public List<SuburbView> getKeyRs() {
        return keyRs;
    }

    public SuburbView getView() {
        return this.view;
    }

    public void setView(SuburbView view) {
        this.view = view;
    }

    public List<AreaView> getQcAreas() {
        return qcAreas;
    }

    @Override
    public ViewConverter<Suburb, SuburbView> getConverter() {
        return ConverterFactory.getConverter(Suburb.class);
    }

    @Override
    public IBaseService<Suburb, Long> getService() {
        return this.suburbService;
    }

}
