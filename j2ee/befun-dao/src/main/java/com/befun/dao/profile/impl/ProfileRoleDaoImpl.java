package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.ProfileRoleDao;
import com.befun.domain.profile.ProfileRole;

@Repository("ProfileRoleDao")
public class ProfileRoleDaoImpl extends BaseHibernateDao<ProfileRole, Long> implements ProfileRoleDao {

}
