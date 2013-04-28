package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.ProfileDao;
import com.befun.domain.profile.Profile;

@Repository("ProfileDao")
public class ProfileDaoImpl extends BaseHibernateDao<Profile, Long> implements ProfileDao {

}
