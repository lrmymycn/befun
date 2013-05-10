package com.befun.service.profile;

import java.util.List;

import com.befun.domain.profile.Employee;
import com.befun.domain.profile.RoleCode;
import com.befun.service.IBaseService;
import com.befun.service.query.profile.EmployeeQueryCondition;

public interface EmployeeService extends IBaseService<Employee, Long> {

    List<Employee> queryEmployeesByManager(Long managerId, EmployeeQueryCondition qc);

    Employee getEmployeeByRole(Long id, RoleCode roleCode);
}
