package com.befun.web.action.admin.profile;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Employee;
import com.befun.domain.profile.EmployeeClient;
import com.befun.domain.profile.RoleCode;
import com.befun.service.IBaseService;
import com.befun.service.profile.EmployeeClientService;
import com.befun.service.profile.EmployeeService;
import com.befun.service.query.profile.EmployeeClientQueryCondition;
import com.befun.service.query.profile.EmployeeQueryCondition;

@Controller("AdminEmployeeClientAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeClientAction<M extends EmployeeClient> extends ProfileCRUDAction<EmployeeClient> {

    private static final long serialVersionUID = 5495201659557835300L;

    private static final String[] UPDATE_IGNORED_PROPS = new String[] { "startDate", "endDate" };

    private EmployeeClientQueryCondition qc = new EmployeeClientQueryCondition();

    private List<Employee> paramEmployees;

    @Resource
    @Qualifier("EmployeeClientService")
    private EmployeeClientService service;

    @Resource
    @Qualifier("EmployeeService")
    private EmployeeService employeeService;

    public EmployeeClientAction() {
        this.model = new EmployeeClient();
    }

    @Override
    public void prepare() throws Exception {

    }

    public void prepareDemand() {
        EmployeeQueryCondition qc = new EmployeeQueryCondition();
        RoleCode[] roleCodes = new RoleCode[] { RoleCode.SALE };
        qc.setRoleCodes(roleCodes);
        this.paramEmployees = this.employeeService.query(qc);
    }

    public void prepareDemandById() {
        EmployeeQueryCondition qc = new EmployeeQueryCondition();
        RoleCode[] roleCodes = new RoleCode[] { RoleCode.SALE };
        qc.setRoleCodes(roleCodes);
        this.paramEmployees = this.employeeService.query(qc);
    }

    public void prepareCreatePage() {
        EmployeeQueryCondition qc = new EmployeeQueryCondition();
        RoleCode[] roleCodes = new RoleCode[] { RoleCode.SALE };
        qc.setRoleCodes(roleCodes);
        this.paramEmployees = this.employeeService.query(qc);
    }

    public void setQc(EmployeeClientQueryCondition qc) {
        this.qc = qc;
    }

    public List<Employee> getParamEmployees() {
        return paramEmployees;
    }

    public void setModel(EmployeeClient model) {
        this.model = model;
    }

    public EmployeeClient getModel() {
        return this.model;
    }

    @Override
    public QueryCondition getQc() {
        return qc;
    }

    @Override
    public IBaseService<EmployeeClient, Long> getService() {
        return this.service;
    }

    public String[] getUpdateIgnoredProperties() {
        return UPDATE_IGNORED_PROPS;
    }

}
