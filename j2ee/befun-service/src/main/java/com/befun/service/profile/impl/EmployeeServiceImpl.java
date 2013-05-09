package com.befun.service.profile.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.Employee;
import com.befun.domain.profile.RoleCode;
import com.befun.service.BaseModificationService;
import com.befun.service.profile.EmployeeService;

@Service("EmployeeService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl extends BaseModificationService<Employee, Long> implements EmployeeService {

    private final static String HQL_GETMANAGER_BYID = "select distinct(e) from com.befun.domain.profile.Employee e left join e.profileRoles pr "
                                                      + "where e.id = :managerId AND pr.role.code = :roleCode";

    @Resource
    public void setDao(@Qualifier("EmployeeDao") IBaseDao<Employee, Long> dao) {
        this.dao = dao;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, readOnly = true)
    public List<Employee> getEmployeesByManager(Long managerId) {
        Assert.notNull(managerId, "managerId should be not null!");
        Employee manager = this.getManager(managerId);
        if (manager == null) {
            return new ArrayList<Employee>(0);
        }
        
        String hql = "select distinct(e) from com.befun.domain.profile.Employee e left join e.profileDepartments pd " 
                        + "where ";
        List<Employee> rs = null;

        return rs;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, readOnly = true)
    public Employee getManager(Long managerId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("managerId", managerId);
        paramMap.put("roleCode", RoleCode.MANAGER);
        List<Employee> managers = this.dao.query(HQL_GETMANAGER_BYID, paramMap);
        if (managers == null || managers.size() <= 0) {
            return null;
        }
        if (managers.size() > 1) {
            this.log.warn(managers.size() + " managers found with id:" + managerId);
        }
        Employee rs = managers.get(0);
        return rs;
    }

}
