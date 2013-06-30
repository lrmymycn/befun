package com.befun.web.action;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.BaseModel;
import com.befun.domain.PaginationBean;
import com.befun.service.IBaseService;
import com.befun.service.estate.BaseEstateService;
import com.befun.web.view.BaseEasteView;
import com.befun.web.view.converter.ViewConverter;

public abstract class CRUDAction<M extends BaseModel<Long>, V extends BaseEasteView<M>> extends BaseAction {

    private static final long serialVersionUID = -1189470712587953039L;

    private static final String[] DEFAULT_UPDATE_IGNORED_PROPS = new String[] { "modelModification" };

    protected Long id;

    protected Long pn = 1l;

    protected Integer ps = 20;

    protected PaginationBean<V> pgb = null;

    protected V view = null;

    protected boolean editable = false;

    public String createPage() {
        return SUCCESS;
    }

    public String create() {
        try {
            M model = this.getConverter().convertToModel(this.view);
            this.getService().save(model);
            this.addActionMessage("Create successfully! ID:" + model.getId());
        } catch (Exception ex) {
            String errMsg = "Create failure! Object:" + this.view;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String remove() {
        try {
            this.getService().delete(this.id);
            this.addActionMessage("Remove successfully! ID:" + this.id);
        } catch (Exception ex) {
            String errMsg = "Remove failure! Id:" + id;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String removeDependency() {
        return SUCCESS;
    }
    
    public String update() {
        try {
            M model = this.getConverter().convertToModel(this.view);
            this.getService().update(model, this.getUpdateIgnoredProperties());
            this.addActionMessage("Update successfully!");
        } catch (Exception ex) {
            String errMsg = "Update failure! Object:" + this.view;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String createOrUpdate() {
        if (this.view.getId() == null) {
            return this.create();
        } else {
            return this.update();
        }
    }

    public String enable() {
        try {
            if (this.getService() instanceof BaseEstateService) {
                BaseEstateService<?, Long> estateService = (BaseEstateService<?, Long>) this.getService();
                estateService.enable(this.id);
                this.addActionMessage("Enabled!");
            }
        } catch (Exception ex) {
            String errMsg = "Enable failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String disable() {
        try {
            if (this.getService() instanceof BaseEstateService) {
                BaseEstateService<?, Long> estateService = (BaseEstateService<?, Long>) this.getService();
                estateService.disable(this.id);
                this.addActionMessage("Disabled!");
            }
        } catch (Exception ex) {
            String errMsg = "Enable failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String demand() {
        try {
            PaginationBean<M> objs = this.getService().query(this.getQc(), pn, ps);
            this.pgb = new PaginationBean<V>();
            this.pgb.setModels(new ArrayList<V>());
            BeanUtils.copyProperties(objs, this.pgb, new String[] { "models" });
            for (M obj : objs.getModels()) {
                V v = this.getConverter().convertToView(obj);
                this.pgb.getModels().add(v);
            }
        } catch (Exception ex) {
            String errMsg = "Demand failure!";
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String demandById() {
        try {
            M obj = this.getService().get(this.getId());
            this.view = this.getConverter().convertToView(obj);
        } catch (Exception ex) {
            String errMsg = "Query failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public Long getPn() {
        return pn;
    }

    public void setPn(Long pn) {
        this.pn = pn;
    }

    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {
        this.ps = ps;
    }

    public PaginationBean<V> getPgb() {
        return pgb;
    }

    public void setPgb(PaginationBean<V> pgb) {
        this.pgb = pgb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String[] getUpdateIgnoredProperties() {
        return DEFAULT_UPDATE_IGNORED_PROPS;
    }

    public abstract QueryCondition getQc();

    // public abstract V getView();

    // public abstract void setView(V view);

    public abstract ViewConverter<M, V> getConverter();

    public abstract IBaseService<M, Long> getService();

}
