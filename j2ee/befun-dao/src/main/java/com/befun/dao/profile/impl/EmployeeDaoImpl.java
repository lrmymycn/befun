package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.EmployeeDao;
import com.befun.domain.profile.Employee;

@Repository("EmployeeDao")
public class EmployeeDaoImpl extends BaseHibernateDao<Employee, Long> implements EmployeeDao {

}
