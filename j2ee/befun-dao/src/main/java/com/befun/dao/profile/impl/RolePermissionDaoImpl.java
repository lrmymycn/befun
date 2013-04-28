package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.RolePermissionDao;
import com.befun.domain.profile.RolePermission;

@Repository("RolePermissionDao")
public class RolePermissionDaoImpl extends BaseHibernateDao<RolePermission, Long> implements RolePermissionDao {

}
