package com.befun.service.profile;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.domain.profile.Employee;
import com.befun.domain.profile.RoleCode;
import com.befun.service.SpringTestBase;
import com.befun.service.query.profile.EmployeeQueryCondition;

public class TestEmployeeService extends SpringTestBase {

    @Resource
    @Qualifier("EmployeeService")
    private EmployeeService target;

    @Test
    public void testQueryEmployeesByManager() {
        EmployeeQueryCondition qc = new EmployeeQueryCondition();
        List<Employee> rs = target.queryEmployeesByManager(-10000l, qc);
        System.out.println(rs.size());
    }

    @Test
    public void testQueryEmployeeByRole() {
        EmployeeQueryCondition qc = new EmployeeQueryCondition();
        RoleCode[] roleCodes = { RoleCode.DATA_ADMIN, RoleCode.SALE };
        qc.setRoleCodes(roleCodes);
        List<Employee> rs = target.query(qc);
        System.out.println(rs.size());
        for (Employee e : rs) {
            System.out.println(e);
        }
    }

    @Test
    public void testQueryEmployeeByIdRole() {
        EmployeeQueryCondition qc = new EmployeeQueryCondition();
        RoleCode[] roleCodes = { RoleCode.DATA_ADMIN, RoleCode.SALE };
        qc.setRoleCodes(roleCodes);
        Employee rs = target.getEmployeeByRole(-10000l, RoleCode.MANAGER);
        System.out.println(rs);
    }

}
