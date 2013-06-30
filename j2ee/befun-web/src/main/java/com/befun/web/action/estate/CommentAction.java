package com.befun.web.action.estate;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Apartment;
import com.befun.service.IBaseService;
import com.befun.service.estate.ApartmentService;
import com.befun.service.query.estate.ApartmentQueryCondition;
import com.befun.web.action.CRUDAction;
import com.befun.web.view.ApartmentView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("CommentAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CommentAction extends CRUDAction<Apartment, ApartmentView> {

    private static final long serialVersionUID = 1423434908904040130L;

    private ApartmentQueryCondition qc = new ApartmentQueryCondition();

    @Resource
    @Qualifier("ApartmentService")
    private ApartmentService service;

    public void setQc(ApartmentQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public ApartmentQueryCondition getQc() {
        return qc;
    }

    public ApartmentView getView() {
        return this.view;
    }

    public void setView(ApartmentView view) {
        this.view = view;
    }

    @Override
    public ViewConverter<Apartment, ApartmentView> getConverter() {
        return ConverterFactory.getConverter(Apartment.class);
    }

    @Override
    public IBaseService<Apartment, Long> getService() {
        return service;
    }

}
