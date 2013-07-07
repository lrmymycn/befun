package com.befun.web.action.estate;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import com.befun.domain.PaginationBean;
import com.befun.domain.community.ProjectComment;
import com.befun.service.estate.ProjectCommentService;
import com.befun.service.query.estate.ProjectCommentQueryCondition;
import com.befun.web.action.BaseAction;

@Controller("ProjectCommentAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectCommentAction extends BaseAction {

    private static final long serialVersionUID = 1423434908904040130L;

    private Long id;

    private Long pn = 1l;

    private Integer ps = 20;

    private PaginationBean<ProjectComment> pgb = null;

    private ProjectCommentQueryCondition qc = new ProjectCommentQueryCondition();

    private ProjectComment model = null;

    @Resource
    @Qualifier("ProjectCommentService")
    private ProjectCommentService service;

    public void setQc(ProjectCommentQueryCondition qc) {
        this.qc = qc;
    }

    public ProjectCommentQueryCondition getQc() {
        return this.qc;
    }

    public String create() {
        Assert.notNull(this.model);
        if(this.isAnonymous()){
            
        }
        try {
            this.service.save(this.model);
            this.addActionMessage("Create successfully! ID:" + this.model.getId());
        } catch (Exception ex) {
            String errMsg = "Create failure! Object:" + this.model;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String update() {
        Assert.notNull(this.model);
        try {
            this.service.update(this.model);
            this.addActionMessage("Update successfully!");
        } catch (Exception ex) {
            String errMsg = "Update failure! Object:" + this.model;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String demand() {
        try {
            this.pgb = this.service.query(this.qc, pn, ps);
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
            model = this.service.get(this.getId());
        } catch (Exception ex) {
            String errMsg = "Query failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PaginationBean<ProjectComment> getPgb() {
        return pgb;
    }

    public void setPgb(PaginationBean<ProjectComment> pgb) {
        this.pgb = pgb;
    }

    public ProjectComment getModel() {
        return model;
    }

    public void setModel(ProjectComment model) {
        this.model = model;
    }

}
