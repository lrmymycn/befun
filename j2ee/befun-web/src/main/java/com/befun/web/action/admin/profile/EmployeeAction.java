package com.befun.web.action.admin.profile;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Employee;
import com.befun.service.IBaseService;
import com.befun.service.profile.EmployeeService;
import com.befun.service.query.profile.EmployeeQueryCondition;

@Controller("UserAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeAction<M extends Employee> extends ProfileCRUDAction<M> {

    private static final long serialVersionUID = 5495201659557835300L;

    @Resource
    @Qualifier("EmployeeService")
    private EmployeeService service;

    private EmployeeQueryCondition qc;

    private String password;

    private String repeatPassword;
    
    public void validateCreate(){
        if(StringUtils.isBlank(password)){
            this.addFieldError("password", "Password not correct!");
        }
        if(!password.equals(repeatPassword)){
            this.addFieldError("password", "Password not equals Repeat password!");
        }
    }
    
    public String create() {
        this.model.setPassword(password);
        return super.create();
    }

    public String update() {
        return SUCCESS;
    }

    public void setQc(EmployeeQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public QueryCondition getQc() {
        return qc;
    }

    @SuppressWarnings("unchecked")
    @Override
    public IBaseService<M, Long> getService() {
        return (IBaseService<M, Long>)this.service;
    }

}
