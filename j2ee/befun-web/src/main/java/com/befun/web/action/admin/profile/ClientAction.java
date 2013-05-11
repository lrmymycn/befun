package com.befun.web.action.admin.profile;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.FetchMode;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.dao.common.FetchConfig;
import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Client;
import com.befun.domain.profile.ClientStatus;
import com.befun.domain.profile.ClientTitle;
import com.befun.domain.profile.Employee;
import com.befun.domain.profile.RoleCode;
import com.befun.service.IBaseService;
import com.befun.service.profile.ClientService;
import com.befun.service.profile.EmployeeService;
import com.befun.service.query.profile.ClientQueryCondition;
import com.befun.service.query.profile.EmployeeQueryCondition;

@Controller("AdminClientAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClientAction<M extends Client> extends AbstractProfileAction<Client> {

    private static final long serialVersionUID = 5495201659557835300L;

    private static final String[] UPDATE_IGNORED_PROPS = { "lastActiveDate", "preference" };

    private ClientQueryCondition qc = new ClientQueryCondition();

    private List<Employee> paramEmployees;

    private static ClientTitle[] paramTitles = ClientTitle.values();

    private static ClientStatus[] paramStatus = ClientStatus.values();

    @Resource
    @Qualifier("ClientService")
    private ClientService service;

    @Resource
    @Qualifier("EmployeeService")
    private EmployeeService employeeService;

    public ClientAction() {
        this.model = new Client();
    }

    public void prepareDemand() {
        EmployeeQueryCondition qc = new EmployeeQueryCondition();
        RoleCode[] roleCodes = new RoleCode[] { RoleCode.SALE };
        qc.setRoleCodes(roleCodes);
        this.paramEmployees = this.employeeService.query(qc);
        super.prepare();
    }

    public String demand() {
        FetchConfig fetchConfig = new FetchConfig("currentEmployee", FetchMode.JOIN);
        this.qc.addFetchConfigs(fetchConfig);
        return super.demand();
    }
    
    public void prepareDemandById() {
        EmployeeQueryCondition qc = new EmployeeQueryCondition();
        RoleCode[] roleCodes = new RoleCode[] { RoleCode.SALE };
        qc.setRoleCodes(roleCodes);
        this.paramEmployees = this.employeeService.query(qc);
        super.prepare();
    }

    public void prepareCreatePage() {
        EmployeeQueryCondition qc = new EmployeeQueryCondition();
        RoleCode[] roleCodes = new RoleCode[] { RoleCode.SALE };
        qc.setRoleCodes(roleCodes);
        this.paramEmployees = this.employeeService.query(qc);
        super.prepare();
    }

    public void validateCreate() {
    }

    public void validateUpdate() {
    }

    public void validateCreateOrUpdate() {
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

    public ClientTitle[] getParamTitles() {
        return paramTitles;
    }

    public ClientStatus[] getParamStatus() {
        return paramStatus;
    }

    @Override
    public QueryCondition getQc() {
        return qc;
    }

    @Override
    public IBaseService<Client, Long> getService() {
        return this.service;
    }

    public String[] getUpdateIgnoredProperties() {
        return UPDATE_IGNORED_PROPS;
    }
}
