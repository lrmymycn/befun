package com.befun.web.action.admin.profile;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.BaseModel;
import com.befun.domain.PaginationBean;
import com.befun.service.IBaseService;
import com.befun.web.action.BaseAction;
import com.opensymphony.xwork2.Preparable;

public abstract class ProfileCRUDAction<M extends BaseModel<Long>> extends BaseAction implements Preparable {

    private static final long serialVersionUID = -1189470712587953039L;

    private static final String[] DEFAULT_UPDATE_IGNORED_PROPS = new String[] { "creationDate", "lastModifiedDate" };

    protected Long id;

    protected Long pn = 1l;

    protected Integer ps = 20;

    protected PaginationBean<M> pgb = null;

    protected M model = null;

    protected boolean editable = false;

    public String createPage() {
        return SUCCESS;
    }

    public String create() {
        try {
            this.getService().save(this.model);
            this.addActionMessage("Create successfully! ID:" + model.getId());
        } catch (Exception ex) {
            String errMsg = "Create failure! Object:" + this.model;
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
            String errMsg = "Delete failure! Id:" + id;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String update() {
        try {
            this.getService().update(model, this.getUpdateIgnoredProperties());
            this.addActionMessage("Update successfully!");
        } catch (Exception ex) {
            String errMsg = "Update failure! Object:" + this.model;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String createOrUpdate() {
        if (this.model.getId() == null) {
            return this.create();
        } else {
            return this.update();
        }
    }

    public String demand() {
        try {
            this.pgb = this.getService().query(this.getQc(), pn, ps);
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
            this.model = this.getService().get(this.getId());
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

    public PaginationBean<M> getPgb() {
        return pgb;
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

    public abstract IBaseService<M, Long> getService();

}
