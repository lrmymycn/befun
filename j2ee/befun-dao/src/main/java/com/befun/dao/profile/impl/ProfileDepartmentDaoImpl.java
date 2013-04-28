package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.ProfileDepartmentDao;
import com.befun.domain.profile.ProfileDepartment;

@Repository("ProfileDepartmentDao")
public class ProfileDepartmentDaoImpl extends BaseHibernateDao<ProfileDepartment, Long> implements ProfileDepartmentDao {

}
