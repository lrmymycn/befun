package com.befun.web.action.estate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Floorplan;
import com.befun.service.IBaseService;
import com.befun.service.estate.ApartmentService;
import com.befun.service.estate.FloorplanService;
import com.befun.service.query.ApartmentQueryCondition;
import com.befun.service.query.FloorplanQueryCondition;
import com.befun.web.action.CRUDAction;
import com.befun.web.view.ApartmentView;
import com.befun.web.view.FloorplanView;
import com.befun.web.view.converter.ApartmentConverter;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("FloorplanAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FloorplanAction extends CRUDAction<Floorplan, FloorplanView> {

    private static final long serialVersionUID = 1423434908904040130L;

    private FloorplanQueryCondition qc;
    
    private static ApartmentConverter apConverter = ConverterFactory.getConverter(Apartment.class);

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService service;

    @Resource
    @Qualifier("ApartmentService")
    private ApartmentService apartmentService;

    public String demandById() {
        try {
            Floorplan obj = this.getService().get(this.getId());
            this.view = this.getConverter().convertToView(obj);
            ApartmentQueryCondition queryCondition = new ApartmentQueryCondition();
            queryCondition.setFloorplanId(this.getId());
            List<Apartment> apartmentObjs = this.apartmentService.query(queryCondition);
            List<ApartmentView> apartments = new ArrayList<ApartmentView>();
            for(Apartment a : apartmentObjs){
                ApartmentView av = apConverter.convertToView(a);
                apartments.add(av);
            }
            this.view.setApartments(apartments);
        } catch (Exception ex) {
            String errMsg = "Query failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public void setQc(FloorplanQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public FloorplanQueryCondition getQc() {
        return qc;
    }

    public FloorplanView getView() {
        return this.view;
    }

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
