package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.EmployeeClientDao;
import com.befun.domain.profile.EmployeeClient;

@Repository("EmployeeClientDao")
public class EmployeeClientDaoImpl extends BaseHibernateDao<EmployeeClient, Long> implements EmployeeClientDao {

}
