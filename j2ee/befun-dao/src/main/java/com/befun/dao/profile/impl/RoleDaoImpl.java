package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.RoleDao;
import com.befun.domain.profile.Role;

@Repository("RoleDao")
public class RoleDaoImpl extends BaseHibernateDao<Role, Long> implements RoleDao {

}
