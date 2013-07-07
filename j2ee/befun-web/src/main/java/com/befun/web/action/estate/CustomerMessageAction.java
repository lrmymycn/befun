package com.befun.web.action.estate;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import com.befun.domain.community.CustomerMessage;
import com.befun.service.estate.CustomerMessageService;
import com.befun.web.action.BaseAction;

@Controller("CustomerMessageAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerMessageAction extends BaseAction {

    private static final long serialVersionUID = -8889470535699879226L;

    private CustomerMessage model = new CustomerMessage();

    @Resource
    @Qualifier("CustomerMessageService")
    private CustomerMessageService service;

    public String create() {
        Assert.notNull(model);
        try {
            this.model.setCreationDate(new Date());
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

    public CustomerMessage getModel() {
        return model;
    }

    public void setModel(CustomerMessage model) {
        this.model = model;
    }

}
