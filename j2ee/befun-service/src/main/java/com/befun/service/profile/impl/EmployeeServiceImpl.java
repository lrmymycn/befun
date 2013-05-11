package com.befun.service.profile.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.Employee;
import com.befun.domain.profile.ProfileDepartment;
import com.befun.domain.profile.Role;
import com.befun.domain.profile.RoleCode;
import com.befun.service.BaseModificationService;
import com.befun.service.profile.EmployeeService;
import com.befun.service.profile.ProfileRoleService;
import com.befun.service.profile.RoleService;
import com.befun.service.query.profile.EmployeeQueryCondition;

@Service("EmployeeService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl extends BaseModificationService<Employee, Long> implements EmployeeService {

    private final static String HQL_GETEMPLOYEE_BYID_ROLE = "select distinct(e) from com.befun.domain.profile.Employee e left join e.profileRoles pr "
                                                            + "where e.id = :managerId AND pr.role.code = :roleCode";

    @Resource
    @Qualifier("ProfileRoleService")
    private ProfileRoleService profileRoleService;

    @Resource
    @Qualifier("RoleService")
    private RoleService roleService;

    @Resource
    public void setDao(@Qualifier("EmployeeDao") IBaseDao<Employee, Long> dao) {
        this.dao = dao;
    }

    @Override
    public Long save(Employee model) {
        Assert.notNull(model, "model should be not null!");
        Long pk = dao.save(model);
        RoleCode[] codes = { RoleCode.SALE };
        List<Role> roles = this.roleService.queryRoleByCodes(codes);
        if (!CollectionUtils.isEmpty(roles)) {
            List<Long> roleIds = new ArrayList<Long>();
            for (Role role : roles) {
                roleIds.add(role.getId());
            }
            this.profileRoleService.refreshProfileRoles(pk, roleIds);
        }
        return pk;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, readOnly = true)
    public List<Employee> queryEmployeesByManager(Long managerId, EmployeeQueryCondition qc) {
        Assert.notNull(managerId, "managerId should be not null!");
        Employee manager = this.getEmployeeByRole(managerId, RoleCode.MANAGER);
        if (manager == null) {
            return new ArrayList<Employee>(0);
        }
        Set<ProfileDepartment> profileDepartments = manager.getProfileDepartments();
        List<Long> departmentIds = null;
        if (profileDepartments != null && profileDepartments.size() > 0) {
            departmentIds = new ArrayList<Long>();
            for (ProfileDepartment pd : profileDepartments) {
                departmentIds.add(pd.getDepartment().getId());
            }
        }
        qc.setDepartmentIds(departmentIds.toArray(new Long[] {}));
        if (qc.getRoleCodes() == null || qc.getRoleCodes().length <= 0) {
            RoleCode[] roleCodes = { RoleCode.CLIENT, RoleCode.SALE, RoleCode.INTERNAL_EMPLOYEE };
            qc.setRoleCodes(roleCodes);
        }
        List<Employee> employees = this.dao.query(qc);
        return employees;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, readOnly = true)
    public Employee getEmployeeByRole(Long id, RoleCode roleCode) {
        Assert.notNull(id, "id should be not null!");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("managerId", id);
        paramMap.put("roleCode", roleCode);
        List<Employee> managers = this.dao.query(HQL_GETEMPLOYEE_BYID_ROLE, paramMap);
        if (managers == null || managers.size() <= 0) {
            return null;
        }
        if (managers.size() > 1) {
            this.log.warn(managers.size() + " " + roleCode.toString() + " found with id:" + id);
        }
        Employee rs = managers.get(0);
        return rs;
    }

}
