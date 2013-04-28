package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.DepartmentDao;
import com.befun.domain.profile.Department;

@Repository("DepartmentDao")
public class DepartmentDaoImpl extends BaseHibernateDao<Department, Long> implements DepartmentDao {

}
