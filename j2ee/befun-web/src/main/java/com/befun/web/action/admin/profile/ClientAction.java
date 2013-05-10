package com.befun.web.action.admin.profile;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Client;
import com.befun.domain.profile.Employee;
import com.befun.domain.profile.RoleCode;
import com.befun.service.IBaseService;
import com.befun.service.profile.ClientService;
import com.befun.service.profile.EmployeeService;
import com.befun.service.query.profile.ClientQueryCondition;
import com.befun.service.query.profile.EmployeeQueryCondition;

@Controller("AdminClientAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClientAction<M extends Client> extends ProfileAction<Client> {

    private static final long serialVersionUID = 5495201659557835300L;

    private ClientQueryCondition qc = new ClientQueryCondition();

    private List<Employee> paramEmployees;

    @Resource
    @Qualifier("ClientService")
    private ClientService service;

    @Resource
    @Qualifier("EmployeeService")
    private EmployeeService employeeService;

    public void prepare() {
        EmployeeQueryCondition qc = new EmployeeQueryCondition();
        RoleCode[] roleCodes = new RoleCode[] { RoleCode.SALE };
        qc.setRoleCodes(roleCodes);
        this.paramEmployees = this.employeeService.query(qc);
        super.prepare();
    }

    public String createPage() {
        this.model = new Client();
        return super.createPage();
    }

    public void setQc(ClientQueryCondition qc) {
        this.qc = qc;
    }

    public List<Employee> getParamEmployees() {
        return paramEmployees;
    }

    public void setModel(Client model) {
        this.model = model;
    }

    public Client getModel() {
        return this.model;
    }

    @Override
    public QueryCondition getQc() {
        return qc;
    }

    @Override
    public IBaseService<Client, Long> getService() {
        return this.service;
    }

}
