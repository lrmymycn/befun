package com.befun.web.action.admin.profile;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Employee;
import com.befun.service.IBaseService;
import com.befun.service.profile.EmployeeService;
import com.befun.service.query.QCUtils;
import com.befun.service.query.profile.EmployeeQueryCondition;

@Controller("UserAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeAction<M extends Employee> extends ProfileCRUDAction<Employee> {

    private static final long serialVersionUID = 5495201659557835300L;

    private EmployeeQueryCondition qc = new EmployeeQueryCondition();

    private String password;

    private String repeatPassword;

    @Resource
    @Qualifier("EmployeeService")
    private EmployeeService service;

    @Resource
    @Qualifier(value = "BefunPasswordEncoder")
    private PasswordEncoder passwordEncoder;

    public void validateCreate() {
        if (StringUtils.isBlank(model.getPassword())) {
            this.addFieldError("model.password", "Password not correct!");
        }
        if (!password.equals(repeatPassword)) {
            this.addFieldError("password", "Password not equals Repeat password!");
        }
    }

    public String create() {
        String encodedPassword = this.passwordEncoder.encode(model.getPassword());
        this.model.setPassword(encodedPassword);
        return super.create();
    }

    public void validateUpdate() {
        if (StringUtils.isBlank(model.getPassword())) {
            this.addFieldError("model.password", "Password not correct!");
        }
        if (!password.equals(repeatPassword)) {
            this.addFieldError("password", "Password not equals Repeat password!");
        }
    }

    public String update() {
        String encodedPassword = this.passwordEncoder.encode(model.getPassword());
        this.model.setPassword(encodedPassword);
        return SUCCESS;
    }

    public String demand() {
        if (this.getQc() == null) {
            this.setQc(new EmployeeQueryCondition());
        }
        String lastModifiedDateProp = QCUtils.generatePropertyName(qc.getSelfAlias(), "modification.lastModifiedDate");
        this.getQc().getOrderBy().add(Order.desc(lastModifiedDateProp));
        String creationDateProp = QCUtils.generatePropertyName(qc.getSelfAlias(), "modification.creationDate");
        this.getQc().getOrderBy().add(Order.desc(creationDateProp));
        return super.demand();
    }

    public void setQc(EmployeeQueryCondition qc) {
        this.qc = qc;
    }

    public void setModel(Employee model) {
        this.model = model;
    }

    public Employee getModel() {
        return this.model;
    }

    @Override
    public QueryCondition getQc() {
        return qc;
    }

    @Override
    public IBaseService<Employee, Long> getService() {
        return this.service;
    }

}
