package com.befun.web.action.estate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Suburb;
import com.befun.service.IBaseService;
import com.befun.service.estate.SuburbService;
import com.befun.service.query.SuburbQueryCondition;
import com.befun.web.action.CRUDAction;
import com.befun.web.view.SuburbView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("SuburbAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SuburbAction extends CRUDAction<Suburb, SuburbView> {

    private static final long serialVersionUID = -6022462134369571083L;

    private SuburbQueryCondition qc = new SuburbQueryCondition();

    private List<SuburbView> keyRs = new ArrayList<SuburbView>();

    @Resource
    @Qualifier("SuburbService")
    private SuburbService service;

    public String demandByKey() {
        List<Suburb> queryRs = service.queryByInputKey(this.qc.getKey());
        SuburbView tmpV = null;
        for (Suburb s : queryRs) {
            tmpV = this.getConverter().convertToView(s);
            keyRs.add(tmpV);
        }
        return SUCCESS;
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
    
    @Override
    public ViewConverter<Suburb, SuburbView> getConverter() {
        return ConverterFactory.getConverter(Suburb.class);
    }

    @Override
    public IBaseService<Suburb, Long> getService() {
        return this.service;
    }

}
