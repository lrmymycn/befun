package com.befun.web.action.admin.profile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Employee;
import com.befun.domain.profile.ProfileRole;
import com.befun.domain.profile.Role;
import com.befun.service.IBaseService;
import com.befun.service.profile.EmployeeService;
import com.befun.service.profile.ProfileRoleService;
import com.befun.service.profile.RoleService;
import com.befun.service.query.profile.EmployeeQueryCondition;

@Controller("AdminEmployeeAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeAction<M extends Employee> extends AbstractProfileAction<Employee> {

    private static final long serialVersionUID = 5495201659557835300L;

    private EmployeeQueryCondition qc = new EmployeeQueryCondition();

    private List<Role> currentRoles;

    private List<Role> rightRoles;

    private List<Long> roleIds;

    @Resource
    @Qualifier("EmployeeService")
    private EmployeeService service;

    @Resource
    @Qualifier("ProfileRoleService")
    private ProfileRoleService profileRoleService;

    @Resource
    @Qualifier("RoleService")
    private RoleService roleService;
    
    public EmployeeAction(){
        this.model = new Employee();
    }

    public String assignRolesPage() {
        this.model = this.service.get(this.id);
        if (model == null) {
            return ERROR;
        }
        List<ProfileRole> prs = this.profileRoleService.queryRolesByProfileId(this.id);
        currentRoles = new ArrayList<Role>();
        for (ProfileRole pr : prs) {
            currentRoles.add(pr.getRole());
        }
        List<Role> allRoles = roleService.query(null);
        rightRoles = new ArrayList<Role>();
        for (Role r : allRoles) {
            if (!currentRoles.contains(r)) {
                rightRoles.add(r);
            }
        }
        return SUCCESS;
    }

    public String assignRoles() {
        try {
            this.profileRoleService.refreshProfileRoles(this.id, this.roleIds);
            this.addActionMessage("Assign roles successfully! ID:" + this.id);
        } catch (Exception ex) {
            String errMsg = "Assign roles failure! Employee:" + this.id;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String createPage() {
        this.model = new Employee();
        return super.createPage();
    }

    public List<Role> getCurrentRoles() {
        return currentRoles;
    }

    public List<Role> getRightRoles() {
        return rightRoles;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
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
