package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.PermissionDao;
import com.befun.domain.profile.Permission;

@Repository("PermissionDao")
public class PermissionDaoImpl extends BaseHibernateDao<Permission, Long> implements PermissionDao {

}
